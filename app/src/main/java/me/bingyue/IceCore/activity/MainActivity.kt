package me.bingyue.IceCore.activity

import android.os.Bundle
import android.util.DisplayMetrics
import android.content.Intent
import android.widget.Toast
import me.bingyue.IceCore.R
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import me.bingyue.IceCore.activity.ui.theme.冰社Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val status = isModuleActivated();
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels
        val Get_Screen_Resolution = GetTheZoomLevel(calculateScreenAspectRatio(screenHeight, screenWidth));

        setContent {
            冰社Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    if (Get_Screen_Resolution != null) {
                        Page_Init(a = status, b = Get_Screen_Resolution)
                    };
                }
            }
        }
    }
}



@Composable
fun Page_Init(a: Boolean, b: List<Float>){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    About_module(screenHeight, screenWidth, b);
    Xposed_Status(screenHeight, screenWidth, a, b);
    Module_Setting(screenHeight, screenWidth, b);
    Project_Page(screenHeight, screenWidth, b);
    Donatin(screenHeight, screenWidth, b);
}

@Composable
fun Xposed_Status(screenHeight : Dp, screenWidth: Dp, a: Boolean, b: List<Float>) {
    val context = LocalContext.current
    var Xposed_meesage = context.getString(R.string.xposed_status_no);
    if(a){
        Xposed_meesage = context.getString(R.string.xposed_status_yes);
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 背景矩形，宽度为屏幕宽度的 90%，高度为 20% 的屏幕高度
        Box(
            modifier = Modifier
                .size(
                    width = screenWidth * b[0],
                    height = screenHeight * b[1]
                )
                .offset(
                    x = screenWidth * b[2], // 动态偏移
                    y = screenHeight * b[3]
                )
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(55.dp) // 保持圆角比例
                )
                .clickable {
                    Toast.makeText(context, "(≧▽≦)别~点~了，这里没什么好看的", Toast.LENGTH_SHORT).show()
                }
        )
        Text(
            text = Xposed_meesage,
            modifier = Modifier
                .offset(
                    x = screenWidth * b[4],
                    y = screenHeight * b[5]
                ),
            style = TextStyle(
                fontSize = 20.sp // 字体大小相对屏幕宽度调整
            )
        )

        Box(
            modifier = Modifier
                .size(screenWidth * b[6]) // 设置圆形直径
                .offset(
                    x = screenWidth * b[7], // 动态偏移
                    y = screenHeight * b[8]
                )
                .background(
                    color = MaterialTheme.colorScheme.secondary, // 圆形背景颜色
                    shape = CircleShape // 使用内置的 CircleShape
                )
        )
        AsyncImage(
            model = "file:///android_asset/icon/home_icon.png",
            contentDescription = "图标",
            modifier = Modifier
                .size(screenWidth * b[9])
                .offset(
                    x = screenWidth * b[10],
                    y = screenHeight * b[11]
                ),
            contentScale = ContentScale.Crop
        )
    }
}



@Composable
fun Module_Setting(screenHeight : Dp, screenWidth: Dp, b: List<Float>) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 背景矩形，宽度为屏幕宽度的 90%，高度为 20% 的屏幕高度
        Box(
            modifier = Modifier
                .size(
                    width = screenWidth * b[0],
                    height = screenHeight * b[1]
                )
                .offset(
                    x = screenWidth * b[2], // 动态偏移
                    y = screenHeight * (b[3] + b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(55.dp) // 保持圆角比例
                )
                .clickable {
                    val intent = Intent(context, ModuleActivity::class.java)
                    context.startActivity(intent)
                }
        )
        Text(
            text = context.getString(R.string.Module_Setting),
            modifier = Modifier
                .offset(
                    x = screenWidth *  b[4],
                    y = screenHeight * (b[5] + b[14])
                ),
            style = TextStyle(
                fontSize = 20.sp
            )
        )

        Box(
            modifier = Modifier
                .size(screenWidth * b[6]) // 设置圆形直径
                .offset(
                    x = screenWidth * b[7], // 动态偏移
                    y = screenHeight * (b[8] + b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.secondary, // 圆形背景颜色
                    shape = CircleShape // 使用内置的 CircleShape
                )
        )
        AsyncImage(
            model = "file:///android_asset/icon/settings_icon.png",
            contentDescription = "图标",
            modifier = Modifier
                .size(screenWidth * b[9])
                .offset(
                    x = screenWidth * b[10],
                    y = screenHeight * (b[11] + b[14])
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Project_Page(screenHeight : Dp, screenWidth: Dp, b: List<Float>) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 背景矩形，宽度为屏幕宽度的 90%，高度为 20% 的屏幕高度
        Box(
            modifier = Modifier
                .size(
                    width = screenWidth * b[0],
                    height = screenHeight * b[1]
                )
                .offset(
                    x = screenWidth * b[2], // 动态偏移
                    y = screenHeight * (b[3] + 2 * b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(55.dp) // 保持圆角比例
                )
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/bingqiu456/IceCore"))
                    context.startActivity(intent)
                }
        )
        Text(
            text = context.getString(R.string.Github),
            modifier = Modifier
                .offset(
                    x = screenWidth *  b[4],
                    y = screenHeight * (b[5] + 2 * b[14])
                ),
            style = TextStyle(
                fontSize = 20.sp // 字体大小相对屏幕宽度调整
            )
        )

        Box(
            modifier = Modifier
                .size(screenWidth * b[6]) // 设置圆形直径
                .offset(
                    x = screenWidth * b[7], // 动态偏移
                    y = screenHeight * (b[8] + 2 * b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.secondary, // 圆形背景颜色
                    shape = CircleShape // 使用内置的 CircleShape
                )
        )
        AsyncImage(
            model = "file:///android_asset/icon/star_icon.png",
            contentDescription = "图标",
            modifier = Modifier
                .size(screenWidth * b[9])
                .offset(
                    x = screenWidth * b[10],
                    y = screenHeight * (b[11] + 2 * b[14])
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Donatin(screenHeight : Dp, screenWidth: Dp, b: List<Float>) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 背景矩形，宽度为屏幕宽度的 90%，高度为 20% 的屏幕高度
        Box(
            modifier = Modifier
                .size(
                    width = screenWidth * b[0],
                    height = screenHeight * b[1]
                )
                .offset(
                    x = screenWidth * b[2], // 动态偏移
                    y = screenHeight * (b[3] + 3 * b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(55.dp) // 保持圆角比例
                )
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://afdian.com/a/bingyueblog"))
                    context.startActivity(intent)
                }
        )
        Text(
            text = context.getString(R.string.Donate),
            modifier = Modifier
                .offset(
                    x = screenWidth *  b[4],
                    y = screenHeight * (b[5] + 3 * b[14])
                ),
            style = TextStyle(
                fontSize = 20.sp // 字体大小相对屏幕宽度调整
            )
        )

        Box(
            modifier = Modifier
                .size(screenWidth * b[6]) // 设置圆形直径
                .offset(
                    x = screenWidth * b[7], // 动态偏移
                    y = screenHeight * (b[8] + 3 * b[14])
                )
                .background(
                    color = MaterialTheme.colorScheme.secondary, // 圆形背景颜色
                    shape = CircleShape // 使用内置的 CircleShape
                )
        )
        AsyncImage(
            model = "file:///android_asset/icon/gift_present_icon.png",
            contentDescription = "图标",
            modifier = Modifier
                .size(screenWidth * b[9])
                .offset(
                    x = screenWidth * b[10],
                    y = screenHeight * (b[11] + 3 * b[14])
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun About_module(screenWidth: Dp, screenHeight: Dp, b: List<Float>){
    Text(text = "冰社 / IceCore",
        modifier = Modifier
            .offset(x = screenWidth * b[12], y = screenHeight * b[13]),
        style = TextStyle(
            fontSize = 30.sp
        )
    )
}

fun GetTheZoomLevel(p_: String): List<Float>? {
    val ratioMap = mapOf(
        "20:9" to listOf(0.605f, 0.1f, 0.18f, 0.12f, 0.400f, 0.155f, 0.16f, 0.2f, 0.132f, 0.1f, 0.23f, 0.147f, 0.122f, 0.04f, 0.125f),  // 20:9 比例，假设这是标准比例，不返回具体数值
        "16:9" to listOf(0.605f, 0.12f, 0.175f, 0.12f, 0.400f, 0.163f, 0.16f, 0.2f, 0.134f, 0.1f, 0.23f, 0.150f, 0.16f, 0.04f, 0.15f),  // 16:9 比例对应的宽高比值
        "normal" to listOf(0.605f, 0.1f, 0.18f, 0.12f, 0.400f, 0.155f, 0.16f, 0.2f, 0.132f, 0.1f, 0.23f, 0.147f, 0.122f, 0.04f, 0.125f) // 默认值
    )
    if (p_ in ratioMap){
       return ratioMap[p_];
    }else{
       return ratioMap["normal"];
    }
}

fun calculateScreenAspectRatio(width: Int, height: Int): String {
    val gcd = greatestCommonDivisor(width, height) // 获取最大公约数
    val aspectWidth = width / gcd
    val aspectHeight = height / gcd

    return "$aspectWidth:$aspectHeight"
}


fun greatestCommonDivisor(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}

fun isModuleActivated(): Boolean {
    return false;
}