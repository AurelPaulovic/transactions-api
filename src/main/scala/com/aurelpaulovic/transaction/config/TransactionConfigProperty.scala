package com.aurelpaulovic.transaction.config

trait TransactionConfigProperty {
  def apply(transBlock: => Unit): LastConfigProperty = new LastConfigProperty(this, transBlock)
}