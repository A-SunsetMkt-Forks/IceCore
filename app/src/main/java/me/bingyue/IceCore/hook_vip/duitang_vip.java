package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class duitang_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lapparam){
        XposedHelpers.findAndHookMethod(
                "com.duitang.main.sylvanas.data.model.UserInfo",
                lapparam.classLoader,
                "isVip",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(true);
                    }
                }
        );
    }
}