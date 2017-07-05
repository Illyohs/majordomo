package io.github.illyohs.majordomo

import java.nio.file.{Path, Paths}

import io.github.illyohs.majordomo.messager.{Node, MessageHandler}
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{
  FMLInitializationEvent,
  FMLPostInitializationEvent,
  FMLPreInitializationEvent,
  FMLServerStoppingEvent
}
import net.minecraftforge.fml.common.{FMLCommonHandler, Mod}
import net.minecraftforge.fml.relauncher.Side

@Mod(modid = "majordomo",
     name = "Majordomo",
     modLanguageAdapter = "io.github.illyohs.scorg.ScalaAdapter",
     version = "0.0.1")
object Majordomo {

  val chatDispatcher = new Node

  @EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit = {
    Config.init(
      Paths
        .get(e.getModConfigurationDirectory + "/Majordomo/majordomo.cfg")
        .toFile)
  }

  @EventHandler
  def init(e: FMLInitializationEvent): Unit = {}

  @EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit = {
    if (FMLCommonHandler.instance().getEffectiveSide == Side.SERVER) {
      chatDispatcher.joinCluster(Config.clusterName, Config.port)
    }
    MinecraftForge.EVENT_BUS.register(new MessageHandler)
  }

  @EventHandler
  def serverShutDown(e: FMLServerStoppingEvent): Unit = {

    if (FMLCommonHandler.instance().getEffectiveSide == Side.SERVER) {
      chatDispatcher.shutDownCluster
    }
  }
}
