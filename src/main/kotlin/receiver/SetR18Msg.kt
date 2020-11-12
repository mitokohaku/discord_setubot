package receiver

import org.javacord.api.entity.message.MessageBuilder
import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.listener.message.MessageCreateListener
import utils.ConfigManager
import java.lang.Exception

class SetR18Msg : MessageCreateListener {
    override fun onMessageCreate(event: MessageCreateEvent) {
        if (event.messageAuthor.isServerAdmin) {
            if (event.messageContent.startsWith("!setr18 ", ignoreCase = true) ||
                event.messageContent.startsWith("！setr18 ", ignoreCase = true)
            ) {
                try {
                    when (event.messageContent.substring(8)) {
                        "0" -> {
                            ConfigManager.setConfig("r18", 0)
                            MessageBuilder().append("设置成功!当前模式:仅非R-18")
                        }
                        "1" -> {
                            ConfigManager.setConfig("r18", 1)
                            MessageBuilder().append("设置成功!当前模式:仅R-18")
                        }
                        "2" -> {
                            ConfigManager.setConfig("r18", 2)
                            MessageBuilder().append("设置成功!当前模式:混合")
                        }
                        else -> MessageBuilder().append("输入的参数不合法!").send(event.channel)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}