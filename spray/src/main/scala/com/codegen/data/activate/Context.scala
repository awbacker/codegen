package com.codegen.data.activate

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage._

object Context extends ActivateContext {
    // val storage = new TransientMemoryStorage

    val storage = new relational.PooledJdbcRelationalStorage {
        val jdbcDriver = "org.postgresql.Driver"
        val user = Some("scantrust")
        val password = Some("scantrust")
        val url = "jdbc:postgres://scantrust:scantrust@localhost:5432/st_local"
        val dialect = relational.idiom.postgresqlDialect
    }

}
