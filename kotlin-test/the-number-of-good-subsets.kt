package thenumberofgoodsubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfGoodSubsetsTest {

    @Test
    fun testExample1() {
        assertEquals(6, Solution().numberOfGoodSubsets(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(5, Solution().numberOfGoodSubsets(intArrayOf(4, 2, 3, 15)))
    }

    @Test
    fun testOnlyOnes() {
        assertEquals(0, Solution().numberOfGoodSubsets(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testSinglePrime() {
        assertEquals(1, Solution().numberOfGoodSubsets(intArrayOf(2)))
    }

    @Test
    fun testSquareExcluded() {
        assertEquals(0, Solution().numberOfGoodSubsets(intArrayOf(4, 9, 25)))
    }

    @Test
    fun testOnesMultiply() {
        assertEquals(4, Solution().numberOfGoodSubsets(intArrayOf(1, 1, 2)))
    }
}
