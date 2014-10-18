package com.aurelpaulovic.transaction

trait Transaction {
  protected val conf: TransactionConfig
}

object Transaction {
  final class TransactionStub private[Transaction] ()
  
  def transaction: TransactionStub = new TransactionStub()
  
  implicit def transactionStubToEmptyTransactionConfig(stub: TransactionStub)(implicit tm: TransactionManager): EmptyTransactionConfig = new EmptyTransactionConfig(tm)
}