package io.github.illyohs.majordomo.chat

import java.nio.file.{Files, Paths}
import java.util

class ChannelHandler {

  case class Channel(name: String,
                     prefix: String,
                     owner: String,
                     isPrivate: Boolean,
                     isVoiceOnly: Boolean,
                     mods: util.List[String],
                     voices: util.List[String],
                     mutes: util.List[String])

  val chanList: util.List[Channel] = new util.ArrayList[Channel]
  val channelDir = Paths.get("channels")
  def load: Unit = {
    if (!Files.exists(channelDir)) {
      Files.createDirectory(channelDir)
      chanList.add(
        Channel("Global",
                "G",
                null,
                false,
                false,
                util.Arrays.asList(""),
                util.Arrays.asList(""),
                util.Arrays.asList("")))
    }

  }
}
