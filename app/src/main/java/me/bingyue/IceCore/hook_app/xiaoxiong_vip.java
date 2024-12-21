package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;

public class xiaoxiong_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        if(!Config.com_duapps_recorder__isvip){
            return;
        }
        XposedHelpers.findAndHookMethod(
                "com.duapps.recorder.Rpb",
                lpparam.classLoader,
                "d",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        super.afterHookedMethod(param);
                    }
                }
        );
    }
}
