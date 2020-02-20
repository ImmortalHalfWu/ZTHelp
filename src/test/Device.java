package test;

import immortal.half.wu.IPhoneConnectListener;
import immortal.half.wu.PhoneManager;
import immortal.half.wu.devices.interfaces.IAndroidDevice;

public class Device {

    public static void test() {

        PhoneManager.getInstance().registerDeviceConnectListener(new IPhoneConnectListener() {
            @Override
            public void deviceConnect(String deviceId, IAndroidDevice androidDevice) throws Exception {
//                LogUtil.i("Device", "有设备连接：" + deviceId + "___" + androidDevice.toString());
//                LogUtil.i("Device", PhoneManager.getInstance().getAllAndroidDevice());
            }

            @Override
            public void deviceDisConnect(String deviceId, IAndroidDevice androidDevice) throws Exception {
//                LogUtil.i("Device", "有设备断开连接：" + deviceId + "___" + androidDevice.toString());
//                LogUtil.i("Device", PhoneManager.getInstance().getAllAndroidDevice());
            }
        });

//        List<IAndroidDevice> allAndroidDevice = PhoneManager.getInstance().getAllAndroidDevice();
//        for (IAndroidDevice androidDevice :
//                allAndroidDevice) {
//            Point dxSize = androidDevice.getDxSize();
//            System.out.println(dxSize);
//        }


//        BaseAndroidDevice baseAndroidDevice = new BaseAndroidDevice("0123456789ABCDEF");
//
//        baseAndroidDevice.uninstallApp("com.android.adbkeyboard");
//
//        List<IAndroidApp> allApps = baseAndroidDevice.getAllAppsPackage(null);
//
//        baseAndroidDevice.installApp(
//                FileUtils.DIR_PATH_OTHER + FileUtils.FILE_NAME_KEY_BOARD_APK,
//                "com.android.adbkeyboard"
//        );
//
//        boolean installApp = baseAndroidDevice.isInstallApp("com.android.adbkeyboard");
//
//        System.out.println(installApp);
    }

}
