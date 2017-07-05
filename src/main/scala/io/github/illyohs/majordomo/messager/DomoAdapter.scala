package io.github.illyohs.majordomo.messager

import java.io.OutputStream

import net.minecraft.util.text.{TextComponentString, TextFormatting}
import net.minecraftforge.fml.server.FMLServerHandler
import org.apache.logging.log4j.LogManager
import org.jgroups.{Message, ReceiverAdapter, View}

/**
  * Created by anthony on 6/26/17.
  */
class DomoAdapter extends ReceiverAdapter {

  val log = LogManager.getLogger("Majordomo")

  override def receive(msg: Message): Unit = {

    val mMess: DomoMessage = msg.getObject.asInstanceOf[DomoMessage]

//    mMess.mTypes match {
//      case DomoTypes.CHANNEL_MESSAGE => {}
//      case DomoTypes.CHANNEL_CREATE =>
//      case DomoTypes.CHANNEL_DELETE =>
//      case DomoTypes.CHANNEL_MESSAGE =>
//      case DomoTypes.CHANNEL_EDIT =>
//      case DomoTypes.MESSAGE_ANNOUNCE =>
//      case DomoTypes.MESSAGE_BROADCAST =>
//      case DomoTypes.NODE_JOIN =>
//      case DomoTypes.NODE_LEAVE =>
//    }

    FMLServerHandler.instance.getServer.sendMessage(new TextComponentString(
      "[" + TextFormatting.GREEN + mMess.node + TextFormatting.RESET + "][" + TextFormatting.GOLD + mMess.sender + TextFormatting.RESET + "] " + mMess.message))
//    log.info("[MSG] " + msg.getObject)
  }

//  override def viewAccepted(view: View): Unit = {
//    log.info("new view " + view)
//  }

//  override def getState(output: OutputStream): Unit = {
//    log.info("State is " + output)
//  }

}
