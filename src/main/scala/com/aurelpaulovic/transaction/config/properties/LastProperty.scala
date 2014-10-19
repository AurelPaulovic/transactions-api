package com.aurelpaulovic.transaction.config.properties

import com.aurelpaulovic.transaction.Context

trait LastProperty [T] extends ConfigProperty {
  val property: ConfigProperty
  
  def callBlock(param: Context): T
}

class LastPropertyUnitUnit (val property: ConfigProperty, _block: => Unit) extends LastProperty[Unit] {
  def callBlock(param: Context): Unit = _block
}

class LastPropertyContextUnit (val property: ConfigProperty, _block: Context => Unit) extends LastProperty[Unit] {
  def callBlock(param: Context): Unit = _block(param)
}

class LastPropertyUnitT [T] (val property: ConfigProperty, _block: => T) extends LastProperty[T] {
  def callBlock(param: Context): T = _block
}


class LastPropertyContextT [T] (val property: ConfigProperty, _block: Context => T) extends LastProperty[T] {
  def callBlock(param: Context): T = _block(param)
}
