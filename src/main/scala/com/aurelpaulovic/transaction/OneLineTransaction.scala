package com.aurelpaulovic.transaction

import com.aurelpaulovic.transaction.config.TransactionConfig

class OneLineTransaction private[transaction] (protected val conf: TransactionConfig) extends Transaction {

}