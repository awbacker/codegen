package com.codegen

import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class DataAccessTestSpec extends Specification with Matchers {

    "Data Acess Should" >> {
        "read id #1" >> {
            val sg = new SimpleCodeGen
            val ct = sg.get_data()
            ct(0).id === 1
        }
    }

}
