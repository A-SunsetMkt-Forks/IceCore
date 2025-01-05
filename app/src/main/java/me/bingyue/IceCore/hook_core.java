package me.bingyue.IceCore;

import android.util.Log;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.bingyue.IceCore.config.Config;
import me.bingyue.IceCore.hook_app.*;

public class hook_core{
    public void a(XC_LoadPackage.LoadPackageParam lpparam) {
        com_when_coco_vip.hook_init(lpparam);
    }

    public void b(XC_LoadPackage.LoadPackageParam lpparam) { me_mapleaf_calendar_vip.hook_init(lpparam); }

    public void c(XC_LoadPackage.LoadPackageParam lpparam){ com_clover_daysmatter_vip.hook_init(lpparam); }

    public void d(XC_LoadPackage.LoadPackageParam lpparam){
        webn_stopapp_vip.hook_init(lpparam);
    }

    public void e(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException {
        if(Config.com_lerist_fakelocation__oid_all){
            com_lerist_fakelocation_old.hook_init(lpparam);
        }else{
            fake_location_vip.hook_init(lpparam);
        }
    }

    public void cf(XC_LoadPackage.LoadPackageParam lpparam) {com_jdjdc_jdfastjdc.hook_init(lpparam);}
    public void f(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException{ fanqie_xiao_suo.hook_init(lpparam); }

    public void g(XC_LoadPackage.LoadPackageParam lpparam){
        duitang_vip.hook_init(lpparam);
    }

    public void h(XC_LoadPackage.LoadPackageParam lpparam) { xiaoxiong_vip.hook_init(lpparam); }

    public void k(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException, IllegalAccessException, InstantiationException { com_wangc_bill_vip.hook_init(lpparam);}

    public void l(XC_LoadPackage.LoadPackageParam lpparam)  {cn_ticktick_task_vip.hook_init(lpparam);}

    public void n(XC_LoadPackage.LoadPackageParam lpparam) throws ClassNotFoundException { com_geektoy_nfctool_vip.hook_init(lpparam);}

    public void m(XC_LoadPackage.LoadPackageParam lpparam) {qianji_vip.hook_init(lpparam); qianji_vip.hook_account_check_vip(lpparam);}

    public void w(XC_LoadPackage.LoadPackageParam lpparam) {caiyun_weather.hook_init(lpparam);}

    public void y(XC_LoadPackage.LoadPackageParam lpparam) {vmos_pro.hook_init(lpparam);}

    public void a1(XC_LoadPackage.LoadPackageParam lpparam) {com_estrongs_android_pop.hook_init(lpparam);}

    public void a2(XC_LoadPackage.LoadPackageParam lpparam) {cn_com_langeasy_LangEasyLexis.hook_init(lpparam);}

    public void b2(XC_LoadPackage.LoadPackageParam lpparam) {com_lerist_autocmd.hook_init(lpparam);}

    public void c2(XC_LoadPackage.LoadPackageParam lpparam) {tech_xiangzi_painless.hook_init(lpparam);}

    public void c3(XC_LoadPackage.LoadPackageParam lpparam) {io_moreless_tide.hook_init(lpparam);}

}
