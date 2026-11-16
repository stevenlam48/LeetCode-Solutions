package laststoneweightii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastStoneWeightIiTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(1, solution.lastStoneWeightII(intArrayOf(2, 7, 4, 1, 8, 1)))
    }

    @Test
    fun secondExample() {
        assertEquals(5, solution.lastStoneWeightII(intArrayOf(31, 26, 33, 21, 40)))
    }

    @Test
    fun singleStone() {
        assertEquals(7, solution.lastStoneWeightII(intArrayOf(7)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.lastStoneWeightII(intArrayOf()))
    }

    @Test
    fun duplicateStones() {
        assertEquals(5, solution.lastStoneWeightII(intArrayOf(5, 5, 5)))
    }
}
