package utils

import com.alibaba.fastjson.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.lang.Exception

object ConfigManager {
    private var cfg = File("config.json")

    fun initialization() {
        if (!cfg.exists()) {
            cfg.createNewFile()
        }
        if (getConfig("token").toString().isEmpty() || getConfig("token") == null) {
            resetCfg()
            println("未检测到登录Token 请输入您的Bot Token:")
            val token = readLine()
            setConfig("token", token)
            println("Token设置成功!")
        }
        if (getConfig("apikey").toString().isEmpty() || getConfig("apikey") == null) {
            println("未设置Apikey 是否现在设置? Y/N")
            println("注:虽然不设置Apikey也能使用 但是调度少得可怜 强烈建议前往https://api.lolicon.app 申请apikey")
            while (true) {
                val s = readLine().toString().toLowerCase()
                if (s == "yes" || s == "y") {
                    println("->设置Apikey")
                    println("请输入您的Apikey:")
                    val apikey = readLine().toString()
                    setConfig("apikey", apikey)
                    println("设置Apikey成功!")
                    break
                } else if (s == "n" || s == "no") {
                    setConfig("apikey", "")
                    println("->不设置Apikey")
                    break
                } else {
                    println("输入有误 请输入yes或者no")
                }
            }
        }
    }

    fun getConfig(): JSONObject? {
        return JSONObject.parseObject(cfg.readText(Charsets.UTF_8))
    }

    fun getConfig(key: String): Any? {
        return getConfig()?.get(key)
    }

    fun <T> setConfig(key: String, value: T) {
        try {
            val config = getConfig()
            config?.set(key, value)
            if (config != null) {
                writeCfg(config)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun writeCfg(jsonObject: JSONObject) {
        val osw = OutputStreamWriter(FileOutputStream(cfg), Charsets.UTF_8)
        osw.write(jsonObject.toJSONString())
        osw.flush()
        osw.close()
    }

    fun resetCfg() {
        writeCfg(JSONObject())
    }
}