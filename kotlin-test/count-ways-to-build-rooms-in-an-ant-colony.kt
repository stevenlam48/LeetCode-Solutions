package countwaystobuildroomsinanantcolony

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWaysToBuildRoomsInAnAntColonyTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().waysToBuildRooms(intArrayOf(-1, 0, 0, 1, 2)))
    }

    @Test
    fun manyChildren() {
        assertEquals(6, Solution().waysToBuildRooms(intArrayOf(-1, 0, 0, 0)))
    }

    @Test
    fun chain() {
        assertEquals(1, Solution().waysToBuildRooms(intArrayOf(-1, 0, 1, 2)))
    }

    @Test
    fun singleRoom() {
        assertEquals(1, Solution().waysToBuildRooms(intArrayOf(-1)))
    }

    @Test
    fun twoRooms() {
        assertEquals(1, Solution().waysToBuildRooms(intArrayOf(-1, 0)))
    }
}
