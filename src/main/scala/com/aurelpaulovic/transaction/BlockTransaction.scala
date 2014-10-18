package com.aurelpaulovic.transaction

import com.aurelpaulovic.transaction.config.TransactionConfig

class BlockTransaction private[transaction] (protected val conf: TransactionConfig) extends Transaction {
  def apply(transBlock: => Unit): Unit = {
    println("start BlockTransaction")
    
    transBlock
    
    println("end BlockTransaction")
  }
  
  def tryExecute(transBlock: => Unit): Option[Boolean] = {
    println("start BlockTransaction with tryExecute")

    transBlock    
        
    println("end BlockTransaction with tryExecute")

    Some(true)
  }
}