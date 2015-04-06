package com.aurelpaulovic.transaction.config.properties

import com.aurelpaulovic.transaction.config.returntype.ForceOption

class Locking () extends ConfigProperty with ForceOption

object Locking {
  def apply(): Locking = new Locking()
}