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


        // 使用 for 循环遍历 Map
        Config().settingsMap.forEach { (sectionTitle, settings) ->
            SectionTitle(title = sectionTitle);
            settings.forEach { setting ->
                val (name, id, description) = setting
                SettingItemWithSwitch(label = name, description = description, id = id)
            }
        }
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
