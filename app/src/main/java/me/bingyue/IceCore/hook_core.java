package me.bingyue.IceCore;

import de.robv.android.xposed.callbacks.XC_LoadPackage;



public class hook_core{
    public void san_liu_wu_hook(XC_LoadPackage.LoadPackageParam lpparam) {
        com_when_coco_vip.hook_init(lpparam);
    }

    public void yi_ye_hook(XC_LoadPackage.LoadPackageParam lpparam) {
        me_mapleaf_calendar_vip.hook_init(lpparam);
    }

    public void daysmatter_hook(XC_LoadPackage.LoadPackageParam lpparam){
        com_clover_daysmatter_vip.hook_init(lpparam);
    }

    public void webn_stopapp(XC_LoadPackage.LoadPackageParam lpparam){
        webn_stopapp_vip.hook_init(lpparam);
    }
}
