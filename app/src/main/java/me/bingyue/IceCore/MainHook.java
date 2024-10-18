package me.bingyue.IceCore;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class MainHook implements IXposedHookLoadPackage {


    public static final String[] app_PackName  = {"com.when.coco", "me.mapleaf.calendar", "com.clover.daysmatter"};
    private static final Map<String, String> hook_method_app;

    static {
        hook_method_app = new HashMap<>();
        hook_method_app.put("com.when.coco", "san_liu_wu_hook");
        hook_method_app.put("me.mapleaf.calendar", "yi_ye_hook");
        hook_method_app.put("com.clover.daysmatter", "daysmatter_hook");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (check_app_package_name(lpparam.packageName)){
            hook_core hookInstance = new hook_core();
            Class<?> clazz = hookInstance.getClass();
            Method method = clazz.getMethod(hook_method_app.get(lpparam.packageName), XC_LoadPackage.LoadPackageParam.class);
            method.invoke(hookInstance, lpparam);
        }
    }

    public boolean check_app_package_name(String name){
        for (String s : app_PackName) {
            if (name.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
