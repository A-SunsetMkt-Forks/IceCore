package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_geektoy_nfctool_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        final Class clazz = XposedHelpers.findClass("cn.dxl.common.application.Properties", lpparam.classLoader);
        XposedHelpers.setStaticBooleanField(clazz, "isLogin", true);
        XposedHelpers.setStaticBooleanField(clazz, "isConnected", true);
        XposedHelpers.setStaticBooleanField(clazz, "isVIP", true);
    }
}
