package counthousesinacircularstreetii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountHousesInACircularStreetIITest {
    private val solution = Solution()

    @Test
    fun countsFromInitiallyOpenDoor() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(true, false, true)), 3))
    }

    @Test
    fun movesToFirstOpenDoorBeforeCounting() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(true, false, false)), 5))
    }

    @Test
    fun stopsAfterLastOpenDoorFoundThroughK() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(false, true, false)), 4))
    }
}

private class FakeStreet(private val doors: BooleanArray) : Street() {
    private var current = 0

    override fun closeDoor() {
        doors[current] = false
    }

    override fun openDoor() {
        doors[current] = true
    }

    override fun isDoorOpen(): Boolean = doors[current]

    override fun moveRight() {
        current = (current + 1) % doors.size
    }
}
