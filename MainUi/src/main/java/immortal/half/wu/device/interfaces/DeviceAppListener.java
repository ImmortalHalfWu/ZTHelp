package immortal.half.wu.device.interfaces;

import immortal.half.wu.device.division.UIIdleFishProductBean;
import immortal.half.wu.device.division.UIUserInfoBean;
import immortal.half.wu.device.division.interfaces.IUiAndroidDevice;
import immortal.half.wu.device.division.interfaces.IUiApp;
import immotal.half.wu.appManager.beans.IdleFishProductBean;

/**
 * 设备状态监听器回调接口， 当设备连接断开对外部通知
 */
public interface DeviceAppListener {

    /**
     * @param androidDevice 安卓设备
     * @param app 闲鱼app
     * @param userName 闲鱼用户名
     * @param isLogin 是否登录
     */
    void deviceConnect(
            IUiAndroidDevice androidDevice,
            IUiApp<UIIdleFishProductBean, UIUserInfoBean> app,
            UIUserInfoBean userName,
            boolean isLogin);


    /**
     * @param androidDevice 安卓设备
     * @param app 闲鱼app
     */
    void deviceDisConnect(IUiAndroidDevice androidDevice, IUiApp<UIIdleFishProductBean, UIUserInfoBean> app);

}
