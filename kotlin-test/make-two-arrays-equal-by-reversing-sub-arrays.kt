package maketwoarraysequalbyreversingsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeTwoArraysEqualByReversingSubArraysTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().canBeEqual(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertTrue(Solution().canBeEqual(intArrayOf(7), intArrayOf(7)))
    }

    @Test
    fun testExample3() {
        assertFalse(Solution().canBeEqual(intArrayOf(3, 7, 9), intArrayOf(3, 7, 11)))
    }

    @Test
    fun testDifferentMultiplicities() {
        assertFalse(Solution().canBeEqual(intArrayOf(1, 1, 2), intArrayOf(1, 2, 2)))
    }

    @Test
    fun testDuplicatesSameMultiplicities() {
        assertTrue(Solution().canBeEqual(intArrayOf(1, 1, 2, 2), intArrayOf(2, 2, 1, 1)))
    }

    @Test
    fun testEmptyArrays() {
        assertTrue(Solution().canBeEqual(intArrayOf(), intArrayOf()))
    }
}
