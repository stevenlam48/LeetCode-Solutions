package counthousesinacircularstreet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountHousesInACircularStreetTest {
    private val solution = Solution()

    @Test
    fun countsWithOpenDoorAtStartingHouse() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(true, false, true)), 3))
    }

    @Test
    fun countsStartingFromClosedDoor() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(false, true, false)), 3))
    }

    @Test
    fun supportsKGreaterThanHouseCount() {
        assertEquals(3, solution.houseCount(FakeStreet(booleanArrayOf(false, true, false)), 5))
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
