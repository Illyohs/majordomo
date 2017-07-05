package io.github.illyohs.majordomo.messager

import io.github.illyohs.majordomo.Config
import joptsimple.internal.Strings
import org.apache.logging.log4j.LogManager
import org.jgroups.{JChannel, Message}

class Node {

  private val log = LogManager.getLogger("Majordomo")

  private var channel: JChannel = _

  def joinCluster(name: String, port: Int): Unit = {
    System.setProperty("java.net.preferIPv4Stack", Config.forceIPV4.toString)
    System.setProperty("jgroups.port", port.toString)
    channel = new JChannel().setName(name).setReceiver(new DomoAdapter)
    log.info("Connector to cluster")
    channel.connect(name)
  }

  def shutDownCluster: Unit = {
    log.info("Leaving the cluster")
    channel.disconnect()
  }

  def sendMessage(message: Message): Unit = {
    channel.send(message)
  }

}
