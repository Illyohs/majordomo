package io.github.illyohs.majordomo.messager

import io.github.illyohs.majordomo.{Config, Majordomo}
import net.minecraftforge.event.ServerChatEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.server.FMLServerHandler
import org.jgroups.Message

class MessageHandler {

  @SubscribeEvent
  def ServerMessageHandler(e: ServerChatEvent): Unit = {
    val mes = new DomoMessage(Config.nodeName,
                              "cjam",
                              e.getUsername,
                              e.getMessage,
                              DomoTypes.CHANNEL_MESSAGE)
    val message =
      new Message(null, "[" + Config.nodeName + "] " + e.getMessage)
    Majordomo.chatDispatcher.sendMessage(message)
  }
}
