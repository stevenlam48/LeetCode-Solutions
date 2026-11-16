package minimumcosttoconvertstringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConvertStringIITest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(
            28L,
            solution.minimumCost(
                "abcd", "acbe", listOf("a", "b", "c", "c", "e", "d"),
                listOf("b", "c", "b", "e", "b", "e"), intArrayOf(2, 5, 5, 1, 2, 20)
            )
        )
    }

    @Test
    fun convertsAdjacentSegments() {
        assertEquals(
            9L,
            solution.minimumCost(
                "abcdefgh", "acdbefgh", listOf("abc", "def"), listOf("acd", "bef"), intArrayOf(4, 5)
            )
        )
    }

    @Test
    fun equalStringsIgnoreUnrelatedRule() {
        assertEquals(0L, solution.minimumCost("abc", "abc", listOf("z"), listOf("z"), intArrayOf(9)))
    }

    @Test
    fun impossibleConversion() {
        assertEquals(
            -1L,
            solution.minimumCost("ab", "cd", listOf("a"), listOf("c"), intArrayOf(2))
        )
    }
}
