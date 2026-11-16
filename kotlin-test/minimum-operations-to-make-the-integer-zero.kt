package minimumoperationstomaketheintegerzero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeTheIntegerZeroTest {
    @Test
    fun example() {
        assertEquals(3, Solution().makeTheIntegerZero(3, -2))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().makeTheIntegerZero(5, 7))
        assertEquals(-1, Solution().makeTheIntegerZero(0, 0))
    }

    @Test
    fun oneOperation() {
        assertEquals(1, Solution().makeTheIntegerZero(2, 1))
    }

    @Test
    fun negativeMultiplier() {
        assertEquals(1, Solution().makeTheIntegerZero(1, -1))
        assertEquals(2, Solution().makeTheIntegerZero(2, -1))
    }
}
