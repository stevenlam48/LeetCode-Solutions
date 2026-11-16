package painthouseiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintHouseIvTest {
    private val solution = Solution()

    @Test
    fun twoHouses() {
        val cost = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertEquals(6L, solution.minCost(2, cost))
    }

    @Test
    fun fourHousesAndTwoColors() {
        val cost = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(7, 8))
        assertEquals(18L, solution.minCost(4, cost))
    }

    @Test
    fun zeroCost() {
        val cost = Array(4) { IntArray(3) }
        assertEquals(0L, solution.minCost(4, cost))
    }

    @Test
    fun usesLongAccumulator() {
        val cost = arrayOf(
            intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE),
            intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
        )
        assertEquals(4_294_967_294L, solution.minCost(2, cost))
    }
}
