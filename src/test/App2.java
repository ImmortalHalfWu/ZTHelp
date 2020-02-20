package test;

import immortal.half.wu.FileUtils;
import immortal.half.wu.LogUtil;
import immortal.half.wu.adbs.ADBManager;
import immortal.half.wu.executor.ExecutorManager;
import immortal.half.wu.idlefish.IdleFishAppFactory;
import immotal.half.wu.appManager.AppManagerUtil;
import immotal.half.wu.appManager.beans.IdleFishProductBean;
import immotal.half.wu.appManager.interfaces.IApp;
import immotal.half.wu.appManager.interfaces.IAppCallBack;
import immotal.half.wu.appManager.pagers.beans.DeviceInfoBean;
import immotal.half.wu.appManager.pagers.beans.UserInfoBean;

import java.io.File;
import java.util.ArrayList;

public class App2 {

    private final static String IDLE_FISH_PACKAGE_NAME = "com.taobao.idlefish";
    private final static String IDLE_FISH_MAIN_PATH = "com.taobao.fleamarket.home.activity.MainActivity";
    private final static String IDLE_FISH_POSTED_PATH = ".webview.WeexWebViewActivity";
    private final static String IDLE_FISH_POSTED_CHOICE = ".post.activity.publishEntry.PublishEntryActivity";
    private final static String IDLE_FISH_POSTED_CHOICE_IMG = ".mms.activitys.MultiMediaStudioActivity";
    private final static String IDLE_FISH_POSTED_IMG_PROCESS = ".mms.activitys.MultiMediaEditorActivity";
    private final static String IDLE_FISH_POSTED_IMG_TAG = "com.idlefish.flutterbridge.flutterboost.FishFlutterActivity";
    private final static String IDLE_FISH_POSTED_PRODUCT_INFO = "com.idlefish.flutterbridge.flutterboost.FishFlutterActivity";

    // 设备信息
    static String deviceId = "5ENDU19214004179";
    static DeviceInfoBean deviceInfoBean = new DeviceInfoBean(deviceId, ADBManager.getInstance().getDxSize(deviceId));

    public static void test() {
        ADBManager.getInstance();
        IApp<IdleFishProductBean, UserInfoBean> fishIdleApp = IdleFishAppFactory.createFishIdleApp(deviceId, ExecutorManager.createTimeOutExecutorService("App2.test"));
        ArrayList<File> files = new ArrayList<>(9);

        String[] imgUrls = "//img.alicdn.com/imgextra/i1/4003406273/O1CN01k8lZZc1wD55u1WvKK_!!4003406273.jpg,//img.alicdn.com/imgextra/i2/4003406273/O1CN01kpqp6o1wD55ReJnfZ_!!4003406273.jpg,//img.alicdn.com/imgextra/i1/4003406273/O1CN013cx1Vz1wD55TvoP6v_!!4003406273.jpg,//img.alicdn.com/imgextra/i1/4003406273/O1CN01FxwYQq1wD55iPU1ib_!!4003406273.jpg,//img.alicdn.com/imgextra/i1/4003406273/O1CN01Rh5FrT1wD55QJrAht_!!4003406273.jpg,//img.alicdn.com/imgextra/i3/4003406273/O1CN01Jt3sbV1wD55Q4XYEX_!!4003406273.jpg,//img.alicdn.com/imgextra/i4/4003406273/O1CN014iVrXE1wD55P5skLh_!!4003406273.jpg,//img.alicdn.com/imgextra/i4/4003406273/O1CN01C4oQSt1wD55UfBCp2_!!4003406273.jpg,//img.alicdn.com/imgextra/i4/4003406273/O1CN01Vf2BL21wD55P5qXCC_!!4003406273.jpg,//img.alicdn.com/imgextra/i1/4003406273/O1CN01UqqEsT1wD55SCHfEz_!!4003406273.jpg,//img.alicdn.com/imgextra/i2/4003406273/O1CN01n2ImIB1wD55SCFNrm_!!4003406273.jpg,//img.alicdn.com/imgextra/i3/4003406273/O1CN01JuNxcX1wD55Q4WTlR_!!4003406273.jpg,//img.alicdn.com/imgextra/i1/4003406273/O1CN01ank8Ai1wD55P5rPEW_!!4003406273.jpg,//img.alicdn.com/imgextra/i3/4003406273/O1CN01V0346P1wD55T9fXKs_!!4003406273.jpg,//img.alicdn.com/imgextra/i3/4003406273/O1CN01d41N671wD55Tvn41k_!!4003406273.jpg".split(",");

        for (String url :
                imgUrls) {
            files.add(FileUtils.downloadPicture("https:" + url));
        }

        ArrayList<String> tags = new ArrayList<>(0);
        tags.add("tag1");tags.add("tag2");tags.add("tag3");tags.add("tag4");

        IdleFishProductBean idleFishProductBean = new IdleFishProductBean(
                "title", "info",
                files, tags, "12.4", "50.11"
        );

        fishIdleApp.postProduct(idleFishProductBean, new IAppCallBack<Boolean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onComplete(Boolean result) {

            }
        });
        fishIdleApp.startApp(new IAppCallBack<Boolean>() {
            @Override
            public void onError(Exception e) {
                LogUtil.i(AppManagerUtil.TAG, e.getMessage());
            }

            @Override
            public void onComplete(Boolean result) {
                LogUtil.i(AppManagerUtil.TAG, result);
            }
        });

        fishIdleApp.isLogin(new IAppCallBack<Boolean>() {
            @Override
            public void onError(Exception e) {
                LogUtil.i(AppManagerUtil.TAG, e.getMessage());
            }

            @Override
            public void onComplete(Boolean result) {
                LogUtil.i(AppManagerUtil.TAG, result);
            }
        });

        fishIdleApp.getUserName(new IAppCallBack<UserInfoBean>() {
            @Override
            public void onError(Exception e) {
                LogUtil.i(AppManagerUtil.TAG, e.getMessage());
            }

            @Override
            public void onComplete(UserInfoBean result) {
                LogUtil.i(AppManagerUtil.TAG, result);
            }
        });

        fishIdleApp.getPostedProductsName(new IAppCallBack<ArrayList<String>>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onComplete(ArrayList<String> result) {
                LogUtil.i(AppManagerUtil.TAG, result);
            }
        });

        fishIdleApp.refreshPostedProduct(new IAppCallBack<Boolean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onComplete(Boolean result) {

            }
        });

        fishIdleApp.deleteProduct("google开发者大会入场牌", new IAppCallBack<Boolean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onComplete(Boolean result) {

            }
        });

    }


}
