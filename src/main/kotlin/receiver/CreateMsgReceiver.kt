package receiver

import org.javacord.api.DiscordApi

class CreateMsgReceiver(api: DiscordApi) {
    init {
        api.addListener(SetuMsg())
        api.addListener(PingMsg())
        api.addListener(HelpMsg())
    }
}