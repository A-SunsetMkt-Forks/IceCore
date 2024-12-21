package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class me_mapleaf_calendar_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.me_mapleaf_calendar__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod(
                "w5.a0",
                lpparam.classLoader,
                "d",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {}
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        param.setResult(true);
                    }
                }
        );
    }
}
