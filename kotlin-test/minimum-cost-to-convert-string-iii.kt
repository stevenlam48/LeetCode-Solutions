package minimumcosttoconvertstringiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConvertStringIIITest {
    private val solution = Solution()

    @Test
    fun directRule() {
        assertEquals(2, solution.minCost("abc", "adc", listOf(listOf("b", "d")), intArrayOf(2)))
    }

    @Test
    fun wildcardAddsOneToRuleCost() {
        assertEquals(5, solution.minCost("abc", "axc", listOf(listOf("*", "x")), intArrayOf(4)))
    }

    @Test
    fun separateRulesCanBeCheaperThanCombinedRule() {
        val rules = listOf(listOf("ab", "xy"), listOf("a", "x"), listOf("b", "y"))
        assertEquals(5, solution.minCost("abcd", "xycd", rules, intArrayOf(8, 2, 3)))
    }

    @Test
    fun unchangedAndImpossibleInputs() {
        assertEquals(0, solution.minCost("abc", "abc", listOf(listOf("z", "z")), intArrayOf(1)))
        assertEquals(-1, solution.minCost("a", "b", listOf(listOf("a", "c")), intArrayOf(2)))
    }
}
