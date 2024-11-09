package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class xiaoxiong_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
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
