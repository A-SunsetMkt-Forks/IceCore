package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedHelpers;
import me.bingyue.IceCore.config.Config;

public class caiyun_weather {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) {
        hook_vip(lpparam);
    }
    public static void hook_vip(XC_LoadPackage.LoadPackageParam lpparam){
        if (!Config.com_nowcasting_activity__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod("com.nowcasting.entity.UserInfo", lpparam.classLoader, "isVIP", java.lang.String.class, new XC_MethodHook() {
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

        XposedHelpers.findAndHookMethod("com.nowcasting.entity.UserInfo", lpparam.classLoader, "isSvipReal", new XC_MethodHook() {
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
