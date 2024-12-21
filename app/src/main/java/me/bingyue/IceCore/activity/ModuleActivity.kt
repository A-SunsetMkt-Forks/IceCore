package me.bingyue.IceCore.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bingyue.IceCore.activity.ui.theme.冰社Theme
import me.bingyue.IceCore.config.Updata;
import me.bingyue.IceCore.config.Load_Config;
import me.bingyue.IceCore.config.Search;
import android.content.Context
import android.content.SharedPreferences

class SharedPrefsHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("config", Context.MODE_WORLD_READABLE)

    // 查询存储的布尔值
    fun getBoolean(id: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(id, defaultValue)
    }

    // 保存布尔值
    fun putBoolean(id: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(id, value).apply()
    }
}
class ModuleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Load_Config(this);
        setContent {
            冰社Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ModuleSettingsScreen()
                }
            }
        }
    }
}

@Composable
fun ModuleSettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // 左上角标题
        Text(
            text = "模块设置",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 小标题 + 分界线
        SectionTitle("Fake Location")

        // 文本 + 切换键
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_lerist_fakelocation__vip")
        SettingItemWithSwitch("去除APP黑名单", "如上所述", "com_lerist_fakelocation__black_app")
        SettingItemWithSwitch("去除服务器验证", "防止定位突然关闭", "com_lerist_fakelocation__verify")

        SectionTitle("彩云天气")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_nowcasting_activity__isvip")

        SectionTitle("滴滴清单")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","cn_ticktick_task__isvip")

        SectionTitle("倒数日")
        SettingItemWithSwitch("破解内购", "开启之后直接去购买会员，别付款直接返回","com_clover_daysmatter__pay")

        SectionTitle("ES文件管理器")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_estrongs_android_pop__isvip")

        SectionTitle("nfc tool")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_geektoy_nfctool__isvip")

        SectionTitle("一木记帐")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_wangc_bill__isvip")

        SectionTitle("365日历")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_when_coco__isvip")

        SectionTitle("堆糖")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_duitang_main__isvip")

        SectionTitle("番茄小说")
        SettingItemWithSwitch("启用去广告", "仅去广告","com_dragon_read__isvip")

        SectionTitle("一叶日历")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","me_mapleaf_calendar__isvip")

        SectionTitle("钱迹")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_mutangtech_qianji__isvip")

        SectionTitle("小熊录屏")
        SettingItemWithSwitch("启用本地VIP", "仅本地生效","com_duapps_recorder__isvip")

        SectionTitle("小黑屋")
        SettingItemWithSwitch("启用激活码破解", "开启后去激活码随便输入一个支付宝订单号即可","web1n_stopapp__vip",)
    }
}

@Composable
fun SectionTitle(title: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 1.dp
        )
    }
}

@Composable
fun SettingItemWithSwitch(label: String, description: String, id: String) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = label, fontWeight = FontWeight.Medium)
            Text(text = description, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        }
        val result = Search.queryDataByName(id)
        val prefsHelper = remember { SharedPrefsHelper(context) }
        prefsHelper.putBoolean(id, result)
        val isChecked = remember { mutableStateOf(result) }
        Switch(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it
               if(Search.queryDataByName(id)){
                   Updata.updateValue(id, 0)
                   prefsHelper.putBoolean(id, false)
               }else{
                   Updata.updateValue(id, 1)
                   prefsHelper.putBoolean(id, true)
               }
                Toast.makeText(context, "保存成功，请重启目标APP", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
