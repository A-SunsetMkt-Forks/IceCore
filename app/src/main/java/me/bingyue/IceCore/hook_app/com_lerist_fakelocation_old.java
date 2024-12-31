package me.bingyue.IceCore.hook_app;

import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;
import android.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class com_lerist_fakelocation_old {
    public static void hook_init(XC_LoadPackage.LoadPackageParam lpparam){
        XposedHelpers.findAndHookMethod("com.stub.StubApp", lpparam.classLoader, "attachBaseContext", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                XposedHelpers.findAndHookMethod("ކ.ޖ$֏", classLoader, "ށ", java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        if(Config.com_lerist_fakelocation__verify_old){
                            param.args[0]="114.114.114.114";
                        }
                    }
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

                Class<?> JSONClass =XposedHelpers.findClass("com.alibaba.fastjson.JSON",classLoader);

                XposedHelpers.findAndHookMethod("ށ.ރ.ށ.ހ.ށ.ؠ", classLoader, "֏", java.lang.String.class, java.lang.Class.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        if(param.args[0]=="key_userinfo" && Config.com_lerist_fakelocation__vip_old){
                            long proindate=System.currentTimeMillis()+200000000;
                            long tokenTime=System.currentTimeMillis()+500000000;
                            String key = "1#" + Long.toString(proindate) + "#" + Long.toString(tokenTime) + "#T";
                            String data = "{\"key\":\"" + desEncryptECB(key, "Lerist.T") + "\",\"loginName\":\"IceCore\",\"loginTime\":0,\"loginType\":\"email\",\"proindate\":" + Long.toString(proindate) + ",\"stability\":0,\"token\":\"T\",\"type\":1}";
                            param.setResult(XposedHelpers.callStaticMethod(JSONClass,"parseObject",data,param.args[1]));
                            return;
                        }
                        super.afterHookedMethod(param);
                    }
                });

                XposedHelpers.findAndHookMethod("ށ.ރ.ށ.ހ.ށ.ؠ", classLoader, "ނ", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(false);
                    }
                });

                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ހ.ؠ", classLoader, "ށ", java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }
                });

                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ހ.ؠ", classLoader, "ؠ", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(null);
                    }
                });

                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ؠ.֏", classLoader, "ޅ",Context.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                    }
                });

            }
        });

    }


    public static String desEncryptECB(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(content.getBytes());
            return Base64.encodeToString(result, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String desECBDecrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedData = Base64.decode(data, Base64.DEFAULT);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }
}
