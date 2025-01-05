package me.bingyue.IceCore.hook_app;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class android {

    public static void hookInit() {
        XposedHelpers.findAndHookMethod(ClassLoader.class, "loadClass", String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (param.hasThrowable()) return;

                Class<?> cls = (Class<?>) param.getResult();
                String classLoaderInfo = cls.getClassLoader().toString();

                if (classLoaderInfo.contains("/data/fakeloc/libfakeloc.so")) {
                    XposedBridge.log("Detected libfakeloc.so, preparing to hook...");

                    new Thread(() -> {
                        try {
                            Thread.sleep(3500);
                            XposedBridge.log("Starting hooks...");
                            XposedHelpers.findAndHookMethod("com.lerist.inject.utils.ޏ", cls.getClassLoader(), "އ", new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    param.setResult(true); // 强制返回 true
                                    XposedBridge.log("hook fake_location server veify ok.... 1.3.2.2");
                                }
                            });
                            XposedHelpers.findAndHookMethod("com.lerist.inject.utils.ބ", cls.getClassLoader(), "ރ", String.class, int.class, new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    param.args[0] = "114.114.114.114";
                                    XposedBridge.log("hook fake_location server veify ok.... 1.3.2.2");
                                }
                            });

                        } catch (InterruptedException e) {
                            XposedBridge.log("Thread interrupted: " + e.getMessage());
                        } catch (Exception e) {
                            XposedBridge.log("Error during hooking: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }).start();
                }
                if (classLoaderInfo.contains("/data/fl/libfl.so")) {
                    XposedBridge.log("Detected libfl.so, preparing to hook...");

                    new Thread(() -> {
                        try {
                            Thread.sleep(5000); // 延迟执行以确保目标类加载完毕
                            XposedBridge.log("Starting hooks...");
                            XposedHelpers.findAndHookMethod("؛.ޔ", cls.getClassLoader(), "ՠ", new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    param.setResult(true);
                                    XposedBridge.log("hook fake_location server veify ok.... 1.3.5 beta");
                                    super.afterHookedMethod(param);
                                }
                            });
                            XposedHelpers.findAndHookMethod("؛.އ", cls.getClassLoader(), "Ԭ", String.class, int.class, new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    param.args[0] = "114.114.114.114"; // 修改第一个参数为指定 IP
                                    XposedBridge.log("hook fake_location server veify ok.... 1.3.5beta");
                                }
                            });

                        } catch (InterruptedException e) {
                            XposedBridge.log("Thread interrupted: " + e.getMessage());
                        } catch (Exception e) {
                            XposedBridge.log("Error during hooking: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
        });
    }
}
