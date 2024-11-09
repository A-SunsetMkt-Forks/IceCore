package me.bingyue.IceCore;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class MainHook implements IXposedHookLoadPackage {


    public static final String[] app_PackName  = {
            "com.when.coco",
            "me.mapleaf.calendar",
            "com.clover.daysmatter",
            "web1n.stopapp",
            "com.lerist.fakelocation",
            "com.dragon.read",
            "com.duitang.main",
            "com.duapps.recorder",
            "com.wangc.bill"
    };

    public static final String[] app_PackName_Native  = {
            "com.dragon.read"
    };
    private static final Map<String, String> hook_method_app;

    static {
        hook_method_app = new HashMap<>();
        hook_method_app.put("com.when.coco", "a");
        hook_method_app.put("me.mapleaf.calendar", "b");
        hook_method_app.put("com.clover.daysmatter", "c");
        hook_method_app.put("web1n.stopapp", "d");
        hook_method_app.put("com.lerist.fakelocation", "e");
        hook_method_app.put("com.dragon.read", "f");
        hook_method_app.put("com.duitang.main", "g");
        hook_method_app.put("com.duapps.recorder", "h");
        hook_method_app.put("com.wangc.bill", "k");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (check_app_package_name(lpparam.packageName)){
            hook_core hookInstance = new hook_core();
            Class<?> clazz = hookInstance.getClass();
            try {
                Method method = clazz.getMethod(hook_method_app.get(lpparam.packageName), XC_LoadPackage.LoadPackageParam.class);
                method.invoke(hookInstance, lpparam);
            } catch (Exception e){

            }
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

    public boolean check_app_native(String name){
        for (String s : app_PackName_Native){
            if(name.equals(s)){
                return true;
            }
        }
        return false;
    }
}
