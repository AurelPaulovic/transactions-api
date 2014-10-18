package com.aurelpaulovic.transaction.config

class LastConfigProperty (val property: TransactionConfigProperty, block: => Unit) {
  def transBlock(): Unit = block
}