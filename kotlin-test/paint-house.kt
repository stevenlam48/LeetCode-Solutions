package painthouse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintHouseTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(10, solution.minCost(arrayOf(intArrayOf(17, 2, 17), intArrayOf(16, 16, 5), intArrayOf(14, 3, 19))))
        assertEquals(2, solution.minCost(arrayOf(intArrayOf(7, 6, 2))))
    }

    @Test
    fun emptyCosts() {
        assertEquals(0, solution.minCost(emptyArray()))
    }

    @Test
    fun repeatedChoices() {
        val costs = arrayOf(intArrayOf(1, 5, 9), intArrayOf(8, 1, 7), intArrayOf(6, 4, 1), intArrayOf(1, 8, 6))
        assertEquals(4, solution.minCost(costs))
    }
}
