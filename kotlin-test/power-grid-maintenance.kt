package powergridmaintenance

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PowerGridMaintenanceTest {
    @Test
    fun connectedGrid() {
        assertArrayEquals(
            intArrayOf(3, 2, 3),
            Solution().processQueries(
                5,
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5)),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(1, 2)
                )
            )
        )
    }

    @Test
    fun disconnectedStations() {
        assertArrayEquals(
            intArrayOf(1, -1, -1, -1),
            Solution().processQueries(
                3,
                emptyArray(),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(1, 3)
                )
            )
        )
    }

    @Test
    fun offlineStationDoesNotAffectOtherComponents() {
        assertArrayEquals(
            intArrayOf(2, 4),
            Solution().processQueries(
                4,
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                arrayOf(
                    intArrayOf(2, 1),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 3)
                )
            )
        )
    }
}
