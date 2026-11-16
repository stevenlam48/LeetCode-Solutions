package numberofsquarefularrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSquarefulArraysTest {
    @Test
    fun testExample1() {
        assertEquals(2, Solution().numSquarefulPerms(intArrayOf(1, 17, 8)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().numSquarefulPerms(intArrayOf(2, 2, 2)))
    }

    @Test
    fun testNoSquarefulPermutation() {
        assertEquals(0, Solution().numSquarefulPerms(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testZeros() {
        assertEquals(1, Solution().numSquarefulPerms(intArrayOf(0, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().numSquarefulPerms(intArrayOf(5)))
    }
}
