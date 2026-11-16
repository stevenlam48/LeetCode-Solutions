package removestonestominimizethetotal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveStonesToMinimizeTheTotalTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(12, solution.minStoneSum(intArrayOf(5, 4, 9), 2))
    }

    @Test
    fun secondExample() {
        assertEquals(12, solution.minStoneSum(intArrayOf(4, 3, 6, 7), 3))
    }

    @Test
    fun oneNeverDisappears() {
        assertEquals(1, solution.minStoneSum(intArrayOf(1), 3))
    }

    @Test
    fun zeroOperationsLeavePilesUnchanged() {
        assertEquals(6, solution.minStoneSum(intArrayOf(3, 2, 1), 0))
    }
}
