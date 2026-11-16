package findthemaximumdivisibilityscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumDivisibilityScoreTest {
    @Test
    fun tiedScoresUseSmallestDivisor() {
        assertEquals(2, Solution().maxDivScore(intArrayOf(2, 9, 15, 50), intArrayOf(5, 3, 7, 2)))
    }

    @Test
    fun uniqueMaximumScore() {
        assertEquals(3, Solution().maxDivScore(intArrayOf(4, 7, 9, 3, 9), intArrayOf(5, 2, 3)))
    }

    @Test
    fun repeatedDivisors() {
        assertEquals(5, Solution().maxDivScore(intArrayOf(20, 14, 21, 10), intArrayOf(5, 7, 5)))
    }

    @Test
    fun zeroIsDivisibleByEveryDivisor() {
        assertEquals(2, Solution().maxDivScore(intArrayOf(0, 0), intArrayOf(7, 2, 3)))
    }

    @Test
    fun negativeNumbers() {
        assertEquals(2, Solution().maxDivScore(intArrayOf(-6, -4, 9), intArrayOf(2, 3)))
    }
}
