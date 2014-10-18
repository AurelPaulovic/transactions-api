package com.aurelpaulovic.transaction

import com.aurelpaulovic.transaction.config.TransactionConfigProperty
import com.aurelpaulovic.transaction.config.LastConfigProperty

trait TransactionConfig {
  val tm: TransactionManager
  
  val properties: List[TransactionConfigProperty]
  
  def apply(transBlock: => Unit): Unit = (new BlockTransaction(this)).apply(transBlock)
  
  def tryExecute(transBlock: => Unit): Option[Boolean] = (new BlockTransaction(this)).tryExecute(transBlock)
  
  def using[T <: TransactionConfigProperty](property: T): NonEmptyTransactionConfig = {
    val newProperties = property :: properties
    new NonEmptyTransactionConfig(tm) {
      val properties = newProperties
    }
  }
  
  def using(last: LastConfigProperty): Option[Boolean] = {
    val newProperties = last.property :: properties
    (
        new NonEmptyTransactionConfig(tm) {
          val properties = newProperties
        }
    ) tryExecute (last.transBlock)
  }
}