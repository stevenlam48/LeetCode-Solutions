package maximumsumofthreenumbersdivisiblebythree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfThreeNumbersDivisibleByThreeTest {
    private val solution = Solution()

    @Test
    fun mixedRemainders() {
        assertEquals(15, solution.maximumSum(intArrayOf(3, 6, 5, 1, 8)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.maximumSum(intArrayOf(4)))
    }

    @Test
    fun threeOfEachRemainder() {
        assertEquals(15, solution.maximumSum(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun allMultiplesOfThree() {
        assertEquals(18, solution.maximumSum(intArrayOf(3, 6, 9)))
    }

    @Test
    fun allOnes() {
        assertEquals(3, solution.maximumSum(intArrayOf(1, 1, 1)))
    }
}
