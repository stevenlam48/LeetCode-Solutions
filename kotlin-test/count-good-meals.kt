package countgoodmeals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodMealsTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(4, solution.countPairs(intArrayOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun countsDuplicatePairsSecondExample() {
        assertEquals(15, solution.countPairs(intArrayOf(1, 1, 1, 3, 3, 3, 7)))
    }

    @Test
    fun ignoresZeroSums() {
        assertEquals(0, solution.countPairs(intArrayOf(0, 0, 0)))
    }

    @Test
    fun countsZeroAndOneAsPowerOfTwoSum() {
        assertEquals(1, solution.countPairs(intArrayOf(0, 1)))
    }
}
