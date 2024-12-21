package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class com_geektoy_nfctool_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        if(!Config.com_geektoy_nfctool__isvip){
            return;
        }
       hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod("com.parse.ParseObject", lpparam.classLoader, "getBoolean", java.lang.String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String a = (String) param.args[0];
                if(a.equals("isVIP")){
                    param.setResult(true);
                    hook_sign(lpparam);
                }
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });



        XposedHelpers.findAndHookMethod("com.parse.ParseObject", lpparam.classLoader, "getString", java.lang.String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String a = (String) param.args[0];
                if(a.equals("sign")){
                    param.setResult("");
                }
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });

    }

    public static void hook_sign(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod("cn.dxl.common.util.MD5Util", lpparam.classLoader, "md5", java.lang.String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String a = (String) param.args[0];
                XposedBridge.log(a);
                if(a.contains("truenfctool")){
                    param.setResult("");
                }
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }
}
