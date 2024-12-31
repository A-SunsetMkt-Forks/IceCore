package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class io_moreless_tide {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.io_moreless_tide__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod("io.moreless.tide.base.model.User$Vip", lpparam.classLoader, "getExpired", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(false);
                super.afterHookedMethod(param);
            }
        });
        XposedHelpers.findAndHookMethod("io.moreless.tide.base.model.User$Vip", lpparam.classLoader, "getValid", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                super.afterHookedMethod(param);
            }
        });
        XposedHelpers.findAndHookMethod("k1.l", lpparam.classLoader, "ll", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                super.afterHookedMethod(param);
            }
        });
    }
}
