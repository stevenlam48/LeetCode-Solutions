package wallsandgates

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class WallsAndGatesTest {
    private val solution = Solution()
    private val inf = Int.MAX_VALUE

    @Test
    fun fillsStandardGrid() {
        val rooms = arrayOf(
            intArrayOf(inf, -1, 0, inf),
            intArrayOf(inf, inf, inf, -1),
            intArrayOf(inf, -1, inf, -1),
            intArrayOf(0, -1, inf, inf)
        )
        solution.wallsAndGates(rooms)
        assertRooms(
            arrayOf(
                intArrayOf(3, -1, 0, 1),
                intArrayOf(2, 2, 1, -1),
                intArrayOf(1, -1, 2, -1),
                intArrayOf(0, -1, 3, 4)
            ),
            rooms
        )
    }

    @Test
    fun leavesRoomsUnreachableWhenNoGateExists() {
        val rooms = arrayOf(intArrayOf(inf, -1), intArrayOf(inf, inf))
        solution.wallsAndGates(rooms)
        assertRooms(arrayOf(intArrayOf(inf, -1), intArrayOf(inf, inf)), rooms)
    }

    @Test
    fun handlesSingleGateAndWalls() {
        val rooms = arrayOf(intArrayOf(0, inf), intArrayOf(inf, -1))
        solution.wallsAndGates(rooms)
        assertRooms(arrayOf(intArrayOf(0, 1), intArrayOf(1, -1)), rooms)
    }
}

private fun assertRooms(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertArrayEquals(expected, actual)
}
