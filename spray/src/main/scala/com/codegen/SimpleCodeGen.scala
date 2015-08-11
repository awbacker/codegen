package com.codegen

class SimpleCodeGen {

  // guessing constant interned strings is better than "000000".take(n)
  val zeros = List(
    "",
    "0",
    "00",
    "000",
    "0000",
    "00000",
    "000000",
    "0000000",
    "00000000",
    "000000000",
    "0000000000",
    "00000000000",
    "000000000000"
  )
  val acceptable_characters = "0123456789ABCDEFGHIJKLMNOPQRSTUV" // 32 chars

  /**
   * Takes 2 equal length arrays of values and returns the message for a code
   * @param values originally *args in python
   */
  def generate_message(bits: Seq[Int], values: Seq[Float]): String = {
    (values.map(Math.round), bits)
      .zipped // pair off (value1, bits1), (value2, bits2), etc
      .map(format_field) // convert into left padded binary # of length `bits`
      .mkString("") // string.join
      .grouped(5) // chunk into len 5 (we use 32 chars)
      .map(a => Integer.parseInt(a, 2)) // convert back to integer
      .map(acceptable_characters) // index into characters array
      .mkString("") // string.join
  }


  /**
   * @param value Assumed to never be negative!
   */
  def format_field(value: Int, bit_count: Int): String = {
    val binary_value = Integer.toString(value, 2)
    val repeat_n_times = bit_count - binary_value.length
    if (repeat_n_times >= 0) {
      zeros(repeat_n_times) + binary_value
    } else {
      binary_value
    }
  }

}

