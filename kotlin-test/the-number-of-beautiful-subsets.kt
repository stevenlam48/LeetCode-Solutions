package thenumberofbeautifulsubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfBeautifulSubsetsTest {

    @Test
    fun testExample1() {
        assertEquals(4, Solution().beautifulSubsets(intArrayOf(2, 4, 6), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().beautifulSubsets(intArrayOf(1), 1))
    }

    @Test
    fun testExample3() {
        assertEquals(7, Solution().beautifulSubsets(intArrayOf(1, 2, 3, 4), 1))
    }

    @Test
    fun testDuplicates() {
        assertEquals(15, Solution().beautifulSubsets(intArrayOf(1, 1, 1, 1), 1))
    }

    @Test
    fun testLargeK() {
        assertEquals(7, Solution().beautifulSubsets(intArrayOf(1, 2, 3), 10))
    }

    @Test
    fun testTwoElements() {
        assertEquals(2, Solution().beautifulSubsets(intArrayOf(4, 7), 3))
    }
}
