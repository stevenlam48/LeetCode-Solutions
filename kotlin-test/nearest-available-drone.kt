package nearestavailabledrone

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NearestAvailableDroneTest {
    @Test
    fun `returns nearest drone within range`() {
        val drones = arrayOf(intArrayOf(1, 1, 5), intArrayOf(3, 4, 5), intArrayOf(2, 2, 1))
        assertEquals(2, Solution().nearestDrone(drones, intArrayOf(2, 3)))
    }

    @Test
    fun `skips drones beyond their range`() {
        val drones = arrayOf(intArrayOf(0, 0, 0), intArrayOf(4, 4, 10))
        assertEquals(1, Solution().nearestDrone(drones, intArrayOf(1, 0)))
    }

    @Test
    fun `keeps first drone when distances tie`() {
        val drones = arrayOf(intArrayOf(1, 0, 1), intArrayOf(-1, 0, 1))
        assertEquals(0, Solution().nearestDrone(drones, intArrayOf(0, 0)))
    }

    @Test
    fun `returns minus one when no drone is available`() {
        val drones = arrayOf(intArrayOf(3, 3, 1), intArrayOf(-3, 0, 2))
        assertEquals(-1, Solution().nearestDrone(drones, intArrayOf(0, 0)))
        assertEquals(-1, Solution().nearestDrone(emptyArray(), intArrayOf(0, 0)))
    }
}
