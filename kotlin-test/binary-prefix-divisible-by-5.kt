package binaryprefixdivisibleby5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryPrefixDivisibleBy5Test {
    @Test
    fun example1() {
        assertEquals(
            listOf(true, false, false),
            Solution().prefixesDivBy5(intArrayOf(0, 1, 1)),
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf(false, false, false),
            Solution().prefixesDivBy5(intArrayOf(1, 1, 1)),
        )
    }

    @Test
    fun example3() {
        assertEquals(
            listOf(true, false, false, false, true, false),
            Solution().prefixesDivBy5(intArrayOf(0, 1, 1, 1, 1, 1)),
        )
    }

    @Test
    fun example4() {
        assertEquals(
            listOf(false, false, false, false, false),
            Solution().prefixesDivBy5(intArrayOf(1, 1, 1, 0, 1)),
        )
    }

    @Test
    fun zero() {
        assertEquals(listOf(true), Solution().prefixesDivBy5(intArrayOf(0)))
    }

    @Test
    fun one() {
        assertEquals(listOf(false), Solution().prefixesDivBy5(intArrayOf(1)))
    }
}
