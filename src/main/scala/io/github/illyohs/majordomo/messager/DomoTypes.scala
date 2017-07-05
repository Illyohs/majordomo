package io.github.illyohs.majordomo.messager

object DomoTypes extends Enumeration {
  type MTypes = Value
  val MESSAGE_ANNOUNCE, MESSAGE_BROADCAST, CHANNEL_CREATE, CHANNEL_DELETE,
  CHANNEL_DROP, CHANNEL_MESSAGE, CHANNEL_EDIT, NODE_JOIN, NODE_LEAVE = Value
}
