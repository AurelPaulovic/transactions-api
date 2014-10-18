package com.aurelpaulovic.transaction

import com.aurelpaulovic.transaction.config.TransactionConfigProperty

class EmptyTransactionConfig (val tm: TransactionManager) extends TransactionConfig {
  val properties: List[TransactionConfigProperty] = Nil
}