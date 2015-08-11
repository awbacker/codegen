package com.codegen

import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class CodeGenSpec extends Specification with Matchers {

  "CodeGen should" >> {
    "return the right result" >> {
      val cg = new SimpleCodeGen
      val bits: Array[Int] = Array(10, 3, 3, 3, 3, 7, 10, 6)
      val values: Array[Float] = Array(1, 4.0f, 4.0f, 6.0f, 6.0f, 20, 8, 7)
      val result = cg.generate_message(bits, values)
      result === "01IDH80G7"
    }
  }

}
