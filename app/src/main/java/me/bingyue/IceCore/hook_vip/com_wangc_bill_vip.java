package me.bingyue.IceCore.hook_vip;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class com_wangc_bill_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
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
                        super.afterHookedMethod(param);
                        param.setResult(true);
                    }
                }
        );

        XposedHelpers.findAndHookMethod("com.wangc.bill.http.entity.User", lpparam.classLoader, "getVipType", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1);
                super.afterHookedMethod(param);

            }
        });

        XposedHelpers.findAndHookMethod("com.wangc.bill.entity.ThemeChild", lpparam.classLoader, "isVip", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                super.afterHookedMethod(param);

            }
        });
    }

    public static void hook_viptype(XC_LoadPackage.LoadPackageParam lapparam) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    }
}
