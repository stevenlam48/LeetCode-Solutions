package nestedlistweightsumii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NestedListWeightSumIiTest {
    @Test
    fun `sums values weighted by inverse depth`() {
        val input = listOf(
            NestedInteger(listOf(NestedInteger(1), NestedInteger(1))),
            NestedInteger(2),
            NestedInteger(listOf(NestedInteger(1), NestedInteger(1)))
        )
        assertEquals(8, Solution().depthSumInverse(input))
    }

    @Test
    fun `handles deeply nested values`() {
        val input = listOf(
            NestedInteger(1),
            NestedInteger(listOf(NestedInteger(4), NestedInteger(listOf(NestedInteger(6)))))
        )
        assertEquals(17, Solution().depthSumInverse(input))
    }

    @Test
    fun `handles different depths and empty input`() {
        assertEquals(0, Solution().depthSumInverse(emptyList()))
        val input = listOf(
            NestedInteger(1),
            NestedInteger(listOf(NestedInteger(2))),
            NestedInteger(listOf(NestedInteger(listOf(NestedInteger(3)))))
        )
        assertEquals(10, Solution().depthSumInverse(input))
    }
}
