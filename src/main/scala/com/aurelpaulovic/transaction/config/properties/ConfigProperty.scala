package com.aurelpaulovic.transaction.config.properties

import com.aurelpaulovic.transaction.config.Config
import com.aurelpaulovic.transaction.Context

trait ConfigProperty {
  def apply(transBlock: => Unit): LastPropertyUnitUnit = {
    println("create LastPropertyUnitUnit")
    new LastPropertyUnitUnit(this, transBlock)
  }
  
  def apply[T](transBlock: => T): LastPropertyUnitT[T] = {
    println("create LastPropertyUnitT")
    new LastPropertyUnitT(this, transBlock)
  }
  
  def apply(transBlock: Context => Unit): LastPropertyContextUnit = {
    println("create LastPropertyContextUnit")
    new LastPropertyContextUnit(this, transBlock)
  }
  
  def apply[T](transBlock: Context => T):  LastPropertyContextT[T] = {
    println("create LastPropertyContextT")
    new LastPropertyContextT(this, transBlock)
  }
}

object ConfigProperty {
  implicit def configPropertyToConfig(prop: ConfigProperty): Config = Config(prop)
}