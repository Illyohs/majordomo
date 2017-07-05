package io.github.illyohs.majordomo

import java.io.File

import net.minecraftforge.common.config.Configuration

/**
  * Created by anthony on 6/26/17.
  */
object Config {
  var nodeName: String = _
  var port: Int = _
  var clusterName: String = _
  var forceIPV4: Boolean = _

  var conf: Configuration = _
  def init(e: File): Unit = {

    conf = new Configuration(e)
    conf.load()
    loadConf
  }

  def loadConf: Unit = {
    nodeName = conf
      .get("Node",
           "Node_Name",
           "majordomo",
           "Name of this node on the network.")
      .getString
    port = conf
      .get("Node", "Node_Port", 4628, "the port of the cluster node")
      .getInt
    clusterName = conf
      .get(
        "Node",
        "Group Name",
        "Majordomo",
        "This is the name of the chat group cluster. This is used to Identify other nodes on the cluster DO NOT change this unless you know what your doing"
      )
      .getString

    forceIPV4 = conf
      .get("Node",
           "Force ipv4",
           true,
           "This should be kept true to avoid positional issues")
      .getBoolean

    if (conf.hasChanged) {
      conf.save()
    }
  }
}
