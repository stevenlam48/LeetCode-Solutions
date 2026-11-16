package countconnectedcomponentsinlcmgraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountConnectedComponentsInLcmGraphTest {
    @Test
    fun example() {
        assertEquals(4, Solution().countComponents(intArrayOf(2, 4, 8, 3, 9), 5))
    }

    @Test
    fun oneConnectedComponent() {
        assertEquals(1, Solution().countComponents(intArrayOf(2, 3, 4, 6), 6))
    }

    @Test
    fun thresholdExcludesConnections() {
        assertEquals(3, Solution().countComponents(intArrayOf(2, 7, 14), 13))
        assertEquals(1, Solution().countComponents(intArrayOf(2, 7, 14), 14))
    }

    @Test
    fun duplicatesAndEmptyInput() {
        assertEquals(2, Solution().countComponents(intArrayOf(2, 2, 4), 4))
        assertEquals(0, Solution().countComponents(intArrayOf(), 1))
    }
}
