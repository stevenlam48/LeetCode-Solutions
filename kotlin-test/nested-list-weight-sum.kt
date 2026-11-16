package nestedlistweightsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NestedListWeightSumTest {
    @Test
    fun `sums values weighted by depth`() {
        val input = listOf(
            NestedInteger(1),
            NestedInteger(listOf(NestedInteger(1), NestedInteger(1))),
            NestedInteger(2),
            NestedInteger(listOf(NestedInteger(1), NestedInteger(1)))
        )
        assertEquals(11, Solution().depthSum(input))
    }

    @Test
    fun `handles deeply nested values`() {
        val input = listOf(
            NestedInteger(1),
            NestedInteger(listOf(NestedInteger(4), NestedInteger(listOf(NestedInteger(6)))))
        )
        assertEquals(27, Solution().depthSum(input))
    }

    @Test
    fun `handles empty lists and negative values`() {
        assertEquals(0, Solution().depthSum(emptyList()))
        val input = listOf(NestedInteger(-2), NestedInteger(listOf(NestedInteger(3))))
        assertEquals(4, Solution().depthSum(input))
    }
}
