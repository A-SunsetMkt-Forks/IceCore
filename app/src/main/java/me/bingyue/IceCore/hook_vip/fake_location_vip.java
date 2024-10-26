package me.bingyue.IceCore.hook_vip;

import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class fake_location_vip {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        Class applicationClazz = lpparam.classLoader.loadClass("com.stub.StubApp");
        XposedHelpers.findAndHookMethod(
                applicationClazz,
                "a",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Context context = (Context) param.args[0];
                        ClassLoader finalClassLoader = context.getClassLoader();
                        Class initActivityClazz = finalClassLoader.loadClass("\u0D5F.\u0560");
                        XposedHelpers.findAndHookMethod(
                                initActivityClazz,
                                "\u052A",
                                new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        param.setResult(true);
                                    }
                                }
                        );
                    }
                }
        );
    }
}
