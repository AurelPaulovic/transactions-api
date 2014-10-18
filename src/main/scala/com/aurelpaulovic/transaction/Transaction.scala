package com.aurelpaulovic.transaction

import com.aurelpaulovic.transaction.config.Configuration
import com.aurelpaulovic.transaction.config.TransactionConfig

trait Transaction {
  protected val conf: TransactionConfig
}

object Transaction {
  final class TransactionStub private[Transaction] ()
  
  def transaction: TransactionStub = new TransactionStub()
  
  implicit def transactionStubToEmptyTransactionConfig(stub: TransactionStub)(implicit tm: TransactionManager): TransactionConfig = new Configuration(tm, Nil)
}