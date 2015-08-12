package main

import (
    "fmt"
    "strconv"
    "strings"
    "math"
)

var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUV"
var expected = "01IDH80G7"

func main() {
    var bits = []int{ 10, 3, 3, 3, 3, 7, 10, 6 }
    var args = []float64{ 1, 4, 4, 6.0, 6.0, 20, 8, 7}
    var out = ""
    for i := 0; i < 1000000; i ++ {
        out = GenerateMessage(bits, args)
    }
    fmt.Println(out)
}

func GenerateMessage(bits []int, args []float64) string {
    var bitstring = createBitString(bits, args)
    
    var chunksize = 5
    var chunks = int(math.Ceil(float64(len(bitstring)) / float64(chunksize)))
    var parts = make([]string, chunks)
    for i := 0; i < chunks; i++ {
        var chunk = bitstring[i*chunksize : i*chunksize + chunksize]
        val, _ := strconv.ParseUint(chunk, 2, 32)
        parts[i] = string(chars[val])
    }

    var finalstring = strings.Join(parts, "")

    return finalstring
}

func createBitString(bits []int, args[]float64) string {
    var parts = make([]string, len(args))
    for i, value := range args {
        parts[i] = FillLeftWithZeros(strconv.FormatInt(int64(value), 2), bits[i])
    }
    return strings.Join(parts, "")
}


func FillLeftWithZeros(s string, length int) string {
    return strings.Repeat("0", max(0, length - len(s))) + s
}

func max(a, b int) int {
    if a >= b { return a }
    return b
}
    // val cg = new SimpleCodeGen
    //         val bits: Array[Int] = Array(10, 3, 3, 3, 3, 7, 10, 6)
    //         val values: Array[Float] = Array(1, 4.0f, 4.0f, 6.0f, 6.0f, 20, 8, 7)
    //         val result = cg.generate_message(bits, values)
    //         result === "01IDH80G7"


// https://github.com/DaddyOh/golang-samples/blob/master/pad.go

    // def generate_message(bits: Seq[Int], values: Seq[Float]): String = {
    //     (values.map(Math.round), bits)
    //         .zipped // pair off (value1, bits1), (value2, bits2), etc
    //         .map(format_field) // convert into left padded binary # of length `bits`
    //         .mkString("") // string.join
    //         .grouped(5) // chunk into len 5 (we use 32 chars)
    //         .map(a => Integer.parseInt(a, 2)) // convert back to integer
    //         .map(acceptable_characters) // index into characters array
    //         .mkString("") // string.join
    // }

    // implicit def padLeft(s: String, len: Int, char: Char): String = {
    //     if (s.length >= len) {
    //         s
    //     } else {
    //         zeros(len - s.length) + s
    //     }
    // }

    // /**
    //  * @param value Assumed to never be negative!
    //  */
    // def format_field(value: Int, bit_count: Int): String = {
    //     val binary_value = Integer.toString(value, 2)
    //     binary_value.padLeft(3)
    //     val repeat_n_times = bit_count - binary_value.length
    //     if (repeat_n_times >= 0) {
    //         zeros(repeat_n_times) + binary_value
    //     } else {
    //         binary_value
    //     }
    // }