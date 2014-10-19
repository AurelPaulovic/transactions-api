package com.aurelpaulovic

import com.aurelpaulovic.transaction.config.properties.Locking
import com.aurelpaulovic.transaction.config.properties.Timeout
import com.aurelpaulovic.transaction.config.properties.Retries
import com.aurelpaulovic.transaction.config.Config._
import com.aurelpaulovic.transaction.config.properties.Locking
import com.aurelpaulovic.transaction.Context
import com.aurelpaulovic.transaction.config.properties.ImmediatePublish

object Main2 {
  def main(args: Array[String]): Unit = {
    val x1 = ImmediatePublish() and Timeout(1) {
      println("Unit => Int")
      1
    }
    
    val x2 = ImmediatePublish() and Timeout(2) { context: Context =>
      println("Context => Unit")
    }
    
    ImmediatePublish() and Timeout(200) { context: Context =>
      println("Context => Unit")
    }
    
    ImmediatePublish() and Timeout(202) {
      println("Unit => Unit")
    }
    
    ImmediatePublish() and Timeout(202) {
      println("Unit => Int")
      2.3
    }
    
    val x3 = Timeout(3) and Locking() and Retries(2) {
      println("Unit => Int")
      3
    }
    
    val x4 = Timeout(4) and Locking() and Retries(2) { context: Context =>
      println("Context => Int")
      4
    }
    
    println(x1)
    println(x2)
    println(x3)
    println(x4)
  }
}