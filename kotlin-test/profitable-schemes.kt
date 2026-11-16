package profitableschemes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitableSchemesTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.profitableSchemes(5, 3, intArrayOf(2, 2), intArrayOf(2, 3))
        assertEquals(2, actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.profitableSchemes(10, 5, intArrayOf(2, 3, 5), intArrayOf(6, 7, 8))
        assertEquals(7, actual)
    }

    @Test
    fun validCase3_zeroMinimumProfit() {
        val actual = solution.profitableSchemes(1, 0, intArrayOf(1), intArrayOf(0))
        assertEquals(2, actual)
    }

    @Test
    fun validCase4_capacityExcludesCrime() {
        val actual = solution.profitableSchemes(1, 1, intArrayOf(2, 1), intArrayOf(5, 1))
        assertEquals(1, actual)
    }

    @Test
    fun validCase5_combineCrimesForProfit() {
        val actual = solution.profitableSchemes(2, 2, intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(1, actual)
    }

    @Test
    fun validCase6_allNonemptySchemes() {
        val actual = solution.profitableSchemes(3, 1, intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        assertEquals(7, actual)
    }
}
