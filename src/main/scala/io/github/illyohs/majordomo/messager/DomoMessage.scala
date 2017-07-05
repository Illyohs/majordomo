package io.github.illyohs.majordomo.messager

import io.github.illyohs.majordomo.messager.DomoTypes.MTypes

/**
  * Created by anthony on 6/26/17.
  */
case class DomoMessage(node: String,
                       chan: String,
                       sender: String,
                       message: String,
                       mTypes: MTypes)
