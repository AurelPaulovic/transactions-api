package com.aurelpaulovic.transaction

abstract class NonEmptyTransactionConfig (val tm: TransactionManager) extends TransactionConfig {
  
}