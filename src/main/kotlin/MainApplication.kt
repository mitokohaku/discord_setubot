import org.javacord.api.DiscordApiBuilder
import receiver.CreateMsgReceiver
import utils.getApiKey
import utils.getToken
import utils.initialization
import utils.logi

fun main() {
    initialization()
    val api = DiscordApiBuilder()
        .setToken(getToken())
        .login().join()
    logi("登陆成功!")
    CreateMsgReceiver(api)
    logi("初始化Listener成功!")
    if (getApiKey().isEmpty()) {
        logi("你还没有设置ApiKey 请前往api.lolicon.app获取 未设置apikey每日的调度十分有限 请尽快设置")
    }
}
