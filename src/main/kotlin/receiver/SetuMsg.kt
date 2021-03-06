package receiver

import org.javacord.api.entity.message.MessageBuilder
import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.listener.message.MessageCreateListener
import utils.Setu

class SetuMsg : MessageCreateListener {
    override fun onMessageCreate(event: MessageCreateEvent) {
        if (event.messageContent.equals("setu", ignoreCase = true) || event.messageContent == "来点色图" || event.messageContent == "來點色圖") {
            val setu = Setu()
            if (setu.isSuccess) {
                MessageBuilder()
                    .addFile(setu.getPic())
                    .append(setu.toString())
                    .send(event.channel)
            } else {
                event.channel.sendMessage(setu.msg)
            }
        }
    }
}
