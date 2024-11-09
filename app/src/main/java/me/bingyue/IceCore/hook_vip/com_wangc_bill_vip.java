package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_wangc_bill_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod(
                "com.wangc.bill.http.entity.User",
                lpparam.classLoader,
                "isVip",
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
        hook_viptype(lpparam);
    }

    public static void hook_viptype(XC_LoadPackage.LoadPackageParam lapparam){
        XposedHelpers.findAndHookMethod(
                "com.wangc.bill.entity.ThemeChild",
                lapparam.classLoader,
                "isVip",
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
