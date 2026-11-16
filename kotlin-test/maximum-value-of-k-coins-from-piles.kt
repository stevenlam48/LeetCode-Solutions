package maximumvalueofkcoinsfrompiles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueOfKCoinsFromPilesTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val piles = arrayOf(intArrayOf(1, 100, 3), intArrayOf(7, 8, 9))
        assertEquals(101, solution.maxValueOfCoins(piles, 2))
    }

    @Test
    fun exampleTwo() {
        val piles = arrayOf(
            intArrayOf(100), intArrayOf(100), intArrayOf(100),
            intArrayOf(100), intArrayOf(100), intArrayOf(100),
            intArrayOf(1, 1, 1, 1, 1, 1, 1)
        )
        assertEquals(601, solution.maxValueOfCoins(piles, 7))
    }

    @Test
    fun takeOnlyOneCoin() {
        val piles = arrayOf(intArrayOf(1, 2), intArrayOf(3))
        assertEquals(3, solution.maxValueOfCoins(piles, 1))
    }

    @Test
    fun takeEveryCoin() {
        val piles = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(10, solution.maxValueOfCoins(piles, 4))
    }
}
