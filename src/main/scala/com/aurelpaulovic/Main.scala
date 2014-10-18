package com.aurelpaulovic

import com.aurelpaulovic.transaction.TransactionManager
import com.aurelpaulovic.transaction.config.Retries
import com.aurelpaulovic.transaction.config.Timeout

object Main {
  def main(args: Array[String]): Unit = {
    import com.aurelpaulovic.transaction.Transaction._
    
    implicit val tm = new TransactionManager()
    
    val x1 = transaction {
      println("test1")
    }
    
    val x2 = transaction using Timeout(2) {
      println("test2")
    }
    
    val x3 = transaction using Timeout(3) using Retries(5) {
      println("test3")
    }
  }
}