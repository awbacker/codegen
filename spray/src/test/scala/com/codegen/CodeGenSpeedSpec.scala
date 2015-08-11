package com.codegen

import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class CodeGenSpeedSpec extends Specification with Matchers {

    "CodeGen Speed should" >> {
        "run a million times" >> {
            var v = 0
            for (i <- 1 to 1000000 by 1) {
                val cg = new SimpleCodeGen
                val bits: Array[Int] = Array(10, 3, 3, 3, 3, 7, 10, 6)
                val values: Array[Float] = Array(1, 4.0f, 4.0f, 6.0f, 6.0f, 20, 8, 7)
                val result = cg.generate_message(bits, values)
                result === "01IDH80G7"
                v += 1
            }
            v === 1000000
        }
    }

}
