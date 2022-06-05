package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `ZigZag Conversion` {

    @Test
    fun test1() {
        Assertions.assertEquals(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
    }

    @Test
    fun test2() {
        Assertions.assertEquals(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")
    }

    @Test
    fun test3() {
        Assertions.assertEquals(convert("A", 1), "A")
    }
    @Test
    fun test4() {
        Assertions.assertEquals(convert("ABCD",3), "ABDC")
    }


    fun convert(s: String, numRows: Int): String {
        val length = s.length
        val result = StringBuilder()
        val step = numRows + numRows - 2
        for (i in 0 until numRows) {
            for (j in 0 until length + i step max(step, 1)) {
                if (i != 0 && i != numRows - 1 && j - i >= 0) {
                    result.append(s[j - i])
                }

                if (i + j >= length) {
                    break
                }

                result.append(s[i + j])
            }
        }
        return result.toString()
    }
}