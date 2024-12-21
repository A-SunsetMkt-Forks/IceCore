package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class vmos_pro {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        hook_login(lpparam);
    }

    public static void hook_login(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod("com.vmos.pro.account.AccountHelper", lpparam.classLoader, "notLogin", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(false);
            }
        });
    }
}
