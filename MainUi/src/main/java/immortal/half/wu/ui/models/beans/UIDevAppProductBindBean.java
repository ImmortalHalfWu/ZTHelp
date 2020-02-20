package immortal.half.wu.ui.models.beans;

import immortal.half.wu.device.division.NullUiAndroidDevice;
import immortal.half.wu.device.division.NullUiApp;
import immortal.half.wu.device.division.UIIdleFishProductBean;
import immortal.half.wu.device.division.UIUserInfoBean;
import immortal.half.wu.device.division.interfaces.IUiAndroidDevice;
import immortal.half.wu.device.division.interfaces.IUiApp;
import immotal.half.wu.appManager.beans.IdleFishProductBean;

import java.util.List;
import java.util.Objects;

public class UIDevAppProductBindBean {


    public static UIDevAppProductBindBean create(UIUserInfoBean userName, List<IdleFishUserConfigBean.IdleFishProductBean> products) {
        return new UIDevAppProductBindBean(
                userName,
                NullUiAndroidDevice.getInstance(),
                new NullUiApp<>(),
                products);
    }

    public static UIDevAppProductBindBean create(IUiAndroidDevice androidDevice,
                                                 IUiApp<UIIdleFishProductBean, UIUserInfoBean> app,
                                                 UIUserInfoBean userName,
                                                 List<IdleFishUserConfigBean.IdleFishProductBean> products) {
        return new UIDevAppProductBindBean(
                userName,
                androidDevice,
                app,
                products);
    }


    private UIUserInfoBean userName;
    private IUiAndroidDevice device;
    private IUiApp<UIIdleFishProductBean, UIUserInfoBean> app;
    private List<IdleFishUserConfigBean.IdleFishProductBean> products;

    private UIDevAppProductBindBean(
            UIUserInfoBean userName,
            IUiAndroidDevice device,
            IUiApp<UIIdleFishProductBean, UIUserInfoBean> app,
            List<IdleFishUserConfigBean.IdleFishProductBean> products) {
        this.userName = userName;
        this.device = device;
        this.app = app;
        this.products = products;
    }

    public String getDeviceId() {
        return device.getDeviceId();
    }

    public UIUserInfoBean getUserName() {
        return userName;
    }

    public IUiAndroidDevice getDevice() {
        return device;
    }

    public IUiApp<UIIdleFishProductBean, UIUserInfoBean> getApp() {
        return app;
    }

    public List<IdleFishUserConfigBean.IdleFishProductBean> getProducts() {
        return products;
    }

    public void setUserName(UIUserInfoBean userName) {
        this.userName = userName;
    }

    public void setDevice(IUiAndroidDevice device) {
        this.device = device;
    }

    public void setApp(IUiApp<UIIdleFishProductBean, UIUserInfoBean> app) {
        this.app = app;
    }

    public void setProducts(List<IdleFishUserConfigBean.IdleFishProductBean> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UIDevAppProductBindBean)) return false;
        UIDevAppProductBindBean that = (UIDevAppProductBindBean) o;
        return getDeviceId().equals(that.getDeviceId()) &&
                userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeviceId(), userName);
    }
}
