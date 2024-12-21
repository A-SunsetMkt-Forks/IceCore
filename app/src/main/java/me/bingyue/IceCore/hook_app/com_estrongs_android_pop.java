package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class com_estrongs_android_pop {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        hook_vip(lpparam);
    }

    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.com_estrongs_android_pop__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod("com.estrongs.android.pop.app.account.model.AccountInfo", lpparam.classLoader, "getIsVip", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(true);
            }
        });
    }
}
