package com.aurelpaulovic.transaction.config

import com.aurelpaulovic.transaction.TransactionManager

class Configuration (val tm: TransactionManager, val properties: List[TransactionConfigProperty]) extends TransactionConfig