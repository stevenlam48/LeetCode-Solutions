package minimumcosttoconvertstringi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConvertStringITest {
    private val solution = Solution()

    @Test
    fun leetCodeExampleUsesIndirectConversions() {
        assertEquals(
            28L,
            solution.minimumCost(
                "abcd", "acbe", charArrayOf('a', 'b', 'c', 'c', 'e', 'd'),
                charArrayOf('b', 'c', 'b', 'e', 'b', 'e'), intArrayOf(2, 5, 5, 1, 2, 20)
            )
        )
    }

    @Test
    fun duplicateEdgesUseMinimumCost() {
        assertEquals(
            9L,
            solution.minimumCost(
                "aaa", "zzz", charArrayOf('a', 'a'), charArrayOf('z', 'z'), intArrayOf(10, 3)
            )
        )
    }

    @Test
    fun equalStringsHaveZeroCost() {
        assertEquals(0L, solution.minimumCost("same", "same", CharArray(0), CharArray(0), IntArray(0)))
    }

    @Test
    fun unreachableCharacterReturnsMinusOne() {
        assertEquals(
            -1L,
            solution.minimumCost("a", "c", charArrayOf('a'), charArrayOf('b'), intArrayOf(1))
        )
    }
}
