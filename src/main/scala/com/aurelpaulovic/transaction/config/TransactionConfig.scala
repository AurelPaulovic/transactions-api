package com.aurelpaulovic.transaction.config

import com.aurelpaulovic.transaction.TransactionManager
import com.aurelpaulovic.transaction.BlockTransaction

trait TransactionConfig {
  val tm: TransactionManager
  
  val properties: List[TransactionConfigProperty]
  
  def apply(transBlock: => Unit): Unit = (new BlockTransaction(this)).apply(transBlock)
  
  def tryExecute(transBlock: => Unit): Option[Boolean] = (new BlockTransaction(this)).tryExecute(transBlock)
  
  def using[T <: TransactionConfigProperty](property: T): TransactionConfig = 
    new Configuration(tm, property :: properties)
  
  def using(last: LastConfigProperty): Option[Boolean] = 
    (new Configuration(tm, last.property :: properties)) tryExecute (last.transBlock)
}
