package numberofconnectedcomponentsinanundirectedgraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfConnectedComponentsInAnUndirectedGraphTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().countComponents(
                5,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(3, 4))
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            1,
            Solution().countComponents(
                5,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
            )
        )
    }

    @Test
    fun noEdges() {
        assertEquals(4, Solution().countComponents(4, emptyArray()))
    }

    @Test
    fun redundantEdges() {
        assertEquals(
            2,
            Solution().countComponents(
                4,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(2, 3))
            )
        )
    }
}
