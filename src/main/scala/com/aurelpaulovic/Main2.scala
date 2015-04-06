package com.aurelpaulovic

import com.aurelpaulovic.transaction.config.properties.Locking
import com.aurelpaulovic.transaction.config.properties.Timeout
import com.aurelpaulovic.transaction.config.properties.Retries
import com.aurelpaulovic.transaction.config.Config._
import com.aurelpaulovic.transaction.config.properties.Locking
import com.aurelpaulovic.transaction.Context
import com.aurelpaulovic.transaction.config.properties.ImmediatePublish
import com.aurelpaulovic.transaction.config.returntype.ForceOption

object Main2 {
  def main(args: Array[String]): Unit = {
    val x1 = ImmediatePublish() and Timeout(1) transaction { context =>
      println("Unit => Int ")
      1
    }
    
    val x2 = ImmediatePublish() and Timeout(2) transaction { context =>
      println("Context => Unit " + context)
    }
    
    ImmediatePublish() and Timeout(200) transaction { context: Context =>
      println("Context => Unit")
    }
    
    ImmediatePublish() and Timeout(202) transaction { context: Context with ForceOption =>
      println("Unit => Unit")
    }
    
    ImmediatePublish() and Timeout(202) transaction { context =>
      println("Unit => Int")
      2.3
    }
    
    val x3 = Timeout(3) and Locking() and Retries(2) transaction { context => 
      println("Unit => Int")
      3
    }
    
    val x4 = Timeout(4) and Retries(2) and Locking() transaction { (context: Context) =>
      println("Context => Int " + context)
      4
    }
    
    println(x1)
    println(x2)
    println(x3)
    println(x4)
  }
}