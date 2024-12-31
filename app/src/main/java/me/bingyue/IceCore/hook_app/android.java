package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class android {
    public static void hook_init(){
        XposedHelpers.findAndHookMethod(ClassLoader.class, "loadClass", String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (param.hasThrowable()) return;
                Class<?> cls = (Class<?>) param.getResult();
                if(cls.getClassLoader().toString().contains("/data/fakeloc/libfakeloc.so")) {
                    XposedBridge.log("hook libfakeloc.so");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3500);
                                XposedBridge.log("start");
                                XposedHelpers.findAndHookMethod("com.lerist.inject.utils.ޏ", cls.getClassLoader(), "އ", new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                    }
                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        param.setResult(true);
                                    }
                                });
                                XposedHelpers.findAndHookMethod("com.lerist.inject.utils.ބ", cls.getClassLoader(), "ރ", java.lang.String.class, int.class, new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        param.args[0]="114.114.114.114";//把vef.api.fakeloc.cc改为114.114.114.114
                                    }
                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                    }
                                });
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }
}
