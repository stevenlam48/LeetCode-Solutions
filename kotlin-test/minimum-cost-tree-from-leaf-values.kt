package minimumcosttreefromleafvalues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostTreeFromLeafValuesTest {
    @Test
    fun example1() {
        assertEquals(32, Solution().mctFromLeafValues(intArrayOf(6, 2, 4)))
    }

    @Test
    fun twoLeaves() {
        assertEquals(44, Solution().mctFromLeafValues(intArrayOf(4, 11)))
    }

    @Test
    fun increasing() {
        assertEquals(20, Solution().mctFromLeafValues(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun twoSmall() {
        assertEquals(6, Solution().mctFromLeafValues(intArrayOf(2, 3)))
    }

    @Test
    fun decreasing() {
        assertEquals(20, Solution().mctFromLeafValues(intArrayOf(4, 3, 2, 1)))
    }
}
