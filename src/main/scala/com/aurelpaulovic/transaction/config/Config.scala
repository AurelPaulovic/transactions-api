package com.aurelpaulovic.transaction.config

import com.aurelpaulovic.transaction.config.properties.ConfigProperty
import com.aurelpaulovic.transaction.Context
import com.aurelpaulovic.transaction.config.properties.LastPropertyContextT
import com.aurelpaulovic.transaction.config.properties.LastPropertyUnitUnit
import com.aurelpaulovic.transaction.config.properties.LastPropertyUnitT
import com.aurelpaulovic.transaction.config.properties.LastPropertyContextUnit
import com.aurelpaulovic.transaction.config.returntype.ForceOption

class Config private (properties: List[ConfigProperty]) {
  def and(prop: ConfigProperty): Config = new Config(prop :: properties)
  
  def execute[T](transBlock: Context => T): T = {
    println(s"execute with: ${properties}")
    
    val ret = transBlock(new Object with Context)
    
    println(s"execution end")
    
    ret
  }
  
  def and(lastProp: LastPropertyUnitUnit): Unit = {
    new Config(lastProp.property :: properties).execute(lastProp.callBlock)
    println("after execute with Unit => Unit result")
  }
  
  def and[T](lastProp: LastPropertyUnitT[T]): T = {
    val x = new Config(lastProp.property :: properties).execute(lastProp.callBlock)
    println("after execute with Unit => T result")
    x
  }

  def and(lastProp: LastPropertyContextUnit): Unit = {
    new Config(lastProp.property :: properties).execute(lastProp.callBlock)
    println("after execute with Context => Unit result")
  }
  
  def and[T](lastProp: LastPropertyContextT[T]): T = {
    val x = new Config(lastProp.property :: properties).execute(lastProp.callBlock)
    println("after execute with Context => T result")
    x
  }
  
  //def apply[T](transBlock: => T): Unit = ()
  //def apply[T,U](transBlock: T => U): Unit = ()
  //def apply(transBlock: => Unit): Unit = ()
  //def apply[T](transBlock: T => Unit): Unit = ()
  
  def transaction[T](transBlock: Context with ForceOption => T): Unit = {
    println(" => Unit")
  }
}

object Config {
  def apply(prop: ConfigProperty): Config = new Config(List(prop))
}