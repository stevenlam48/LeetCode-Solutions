package numberofoperationstomakenetworkconnected

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfOperationsToMakeNetworkConnectedTest {
    @Test
    fun oneRedundantCableConnectsRemainingComputer() {
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 2)
        )
        assertEquals(1, Solution().makeConnected(4, connections))
    }

    @Test
    fun connectsMultipleComponentsWhenCablesAreAvailable() {
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 2),
            intArrayOf(1, 3)
        )
        assertEquals(2, Solution().makeConnected(6, connections))
    }

    @Test
    fun rejectsTooFewCables() {
        val connections = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(-1, Solution().makeConnected(4, connections))
    }

    @Test
    fun acceptsSingleComputerAndDuplicateConnections() {
        assertEquals(0, Solution().makeConnected(1, arrayOf()))
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(2, 3)
        )
        assertEquals(2, Solution().makeConnected(5, connections))
    }
}
