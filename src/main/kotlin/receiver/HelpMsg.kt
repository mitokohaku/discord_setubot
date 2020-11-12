package receiver

import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.listener.message.MessageCreateListener

private const val HELP = """
    [帮助]
    恕我直言，在座的各位都是LSP
    [指令]
    <setu / 来点色图> LSP专属指令
    <!setr18 0/1/2> 允许r18(0:仅非r-18 1:仅r-18 2:两者都包含)
    <!help> 帮助菜单
"""

class HelpMsg : MessageCreateListener {
    override fun onMessageCreate(event: MessageCreateEvent) {
        if (event.messageContent.equals("!help", ignoreCase = true) ||
            event.messageContent.equals("！help", ignoreCase = true)
        ) {
            event.channel.sendMessage(HELP)
        }
    }
}