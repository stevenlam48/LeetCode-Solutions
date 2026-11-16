package firstdaywhereyouhavebeeninalltherooms

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstDayWhereYouHaveBeenInAllTheRoomsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().firstDayBeenInAllRooms(intArrayOf(0, 0)))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().firstDayBeenInAllRooms(intArrayOf(0, 0, 2)))
    }

    @Test
    fun example3() {
        assertEquals(6, Solution().firstDayBeenInAllRooms(intArrayOf(0, 1, 2, 0)))
    }

    @Test
    fun allZero() {
        assertEquals(6, Solution().firstDayBeenInAllRooms(intArrayOf(0, 0, 0)))
    }

    @Test
    fun singleRoom() {
        assertEquals(0, Solution().firstDayBeenInAllRooms(intArrayOf(0)))
    }
}
