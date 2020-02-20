package immortal.half.wu.ui.models;

import com.sun.istack.internal.Nullable;
import immortal.half.wu.FileUtils;
import immortal.half.wu.JsonUtil;
import immortal.half.wu.LogUtil;
import immortal.half.wu.ui.models.beans.IdleFishUserConfigBean;
import immortal.half.wu.ui.utils.ThreadUtil;

import java.util.*;

/**
 * 闲鱼用户数据缓存工具类
 */
class UserInfoManager {

    private static UserInfoManager instance;

    static UserInfoManager getInstance() {
        if (instance == null) {
            synchronized (UserInfoManager.class) {
                if (instance == null) {
                    instance = new UserInfoManager();
                }
            }
        }
        return instance;
    }

    private static final String TAG = "UserInfoManager";
    /**
     * 缓存文件名
     */
    private final static String PATH_CACHE_FILE = FileUtils.DIR_PATH_JSON + "UserInfo.json";
    /**
     * 缓存bean
     */
    private final IdleFishUserConfigBean idleFishUserInfoBean;

    /**
     * 用户与商品映射表
     */
    private Map<IdleFishUserConfigBean.IdleFishUserInfoBean, List<IdleFishUserConfigBean.IdleFishProductBean>> userProductMap;

    private UserInfoManager() {
        // 初始化文件
        FileUtils.mkFile(PATH_CACHE_FILE);

        IdleFishUserConfigBean userConfigTemp;
        try {
            userConfigTemp = JsonUtil.fromJson(IdleFishUserConfigBean.class, FileUtils.readFile(PATH_CACHE_FILE));
        } catch (Exception e) {
            userConfigTemp = new IdleFishUserConfigBean(new ArrayList<>());
        }
        // 读取本地文件转bean
        this.idleFishUserInfoBean = userConfigTemp;
    }

    List<IdleFishUserConfigBean.IdleFishUserInfoBean> getUserInfos() {
        return idleFishUserInfoBean == null ? new ArrayList<>() : idleFishUserInfoBean.getIdleFishUserInfoBeans();
    }

    /**
     * 添加一个新用户，如果缓存中没有，则插入
     * @param userName 新用户的用户名
     */
    public void addUser(String userName) {
        List<IdleFishUserConfigBean.IdleFishUserInfoBean> userInfoBeans =
                idleFishUserInfoBean.getIdleFishUserInfoBeans();

        ThreadUtil.runInWork(() -> {
            for (IdleFishUserConfigBean.IdleFishUserInfoBean userInfoBean : userInfoBeans) {
                if (userInfoBean.getUserName().equals(userName)) {
                    return;
                }
            }
            userInfoBeans.add(new IdleFishUserConfigBean.IdleFishUserInfoBean(
                    userName, new ArrayList<>()
            ));
            saveConfigFile.run();
        });

    }

    /**
     * 像指定用户插入指定商品数据
     * @param userName 指定用户
     * @param newProductBean 指定商品数据
     */
    public void addProduct(String userName, IdleFishUserConfigBean.IdleFishProductBean newProductBean) {
        ThreadUtil.runInMain(() -> {
            findProductBean(userName, newProductBean, (isFind, userInfoBeans, userInfoBean, productBeans, productBean) -> {
                if (productBean == null) {
                    productBeans.add(newProductBean);
                }
            });
            saveConfigFile.run();
        });
    }

    /**
     * 删除指定用户下指定商品数据
     * @param userName 指定用户
     * @param newProductBean 指定商品数据
     */
    public void removeProduct(String userName, IdleFishUserConfigBean.IdleFishProductBean newProductBean) {
        ThreadUtil.runInMain(() -> {

            findProductBean(userName, newProductBean, (isFind, userInfoBeans, userInfoBean, productBeans, productBean) -> {
                if (productBean != null) {
                    productBeans.remove(productBean);
                }
            });
            saveConfigFile.run();

        });
    }

    /**
     * 更新指定用户下指定商品数据
     * @param userName 指定用户
     * @param newProductBean 指定商品数据
     */
    public void updataProduct(String userName, IdleFishUserConfigBean.IdleFishProductBean newProductBean) {
        ThreadUtil.runInWork(() -> {
            findProductBean(userName, newProductBean, (isFind, userInfoBeans, userInfoBean, productBeans, productBean) -> {
                if (productBean != null) {
                    int index = productBeans.indexOf(productBean);
                    productBeans.remove(index);
                    productBeans.add(index, newProductBean);
                }
            });
            saveConfigFile.run();
        });
    }

    /**
     * 遍历缓存数据， 查找指定用户下指定商品数据bean
     */
    private void findProductBean(
            String userName,
            IdleFishUserConfigBean.IdleFishProductBean newProductBean,
            ForEachCallback callBack) {

        List<IdleFishUserConfigBean.IdleFishUserInfoBean> userInfoBeans = idleFishUserInfoBean.getIdleFishUserInfoBeans();
        for (IdleFishUserConfigBean.IdleFishUserInfoBean userInfoBean : userInfoBeans){
            if (userInfoBean.getUserName().equals(userName)) {
                List<IdleFishUserConfigBean.IdleFishProductBean> productBeans = userInfoBean.getIdleFishProductModelBeans();
                for (IdleFishUserConfigBean.IdleFishProductBean productBean : productBeans) {
                    if (productBean.getProductUrl().equals(newProductBean.getProductUrl())) {
                        callBack.accept(
                                true,
                                userInfoBeans,
                                userInfoBean,
                                productBeans,
                                productBean
                        );
                        return;
                    }
                }

                callBack.accept(
                        false,
                        userInfoBeans,
                        userInfoBean,
                        productBeans,
                        null
                );
                return;
            }
        }

        callBack.accept(
                false,
                userInfoBeans,
                null,
                null,
                null
        );
    }

    /**
     * 将数据同步到本地
     */
    private volatile Runnable saveConfigFile = new Runnable() {
        @Override
        public void run() {
            try {
                String json = JsonUtil.toJson(idleFishUserInfoBean);
                FileUtils.writeText(PATH_CACHE_FILE, json, false);
            } catch (Exception e) {
                LogUtil.e(TAG, "用户配置文件保存异常：", e);
            }
        }
    };

    private interface ForEachCallback {
        void accept(
                boolean isFind,
                List<IdleFishUserConfigBean.IdleFishUserInfoBean> userInfoBeans,
                @Nullable
                IdleFishUserConfigBean.IdleFishUserInfoBean userInfoBean,
                @Nullable
                List<IdleFishUserConfigBean.IdleFishProductBean> productBeans,
                @Nullable
                IdleFishUserConfigBean.IdleFishProductBean productBean);
    }
}
