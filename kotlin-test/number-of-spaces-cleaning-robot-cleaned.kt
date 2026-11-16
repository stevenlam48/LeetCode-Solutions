package numberofspacescleaningrobotcleaned

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSpacesCleaningRobotCleanedTest {
    @Test
    fun testExample1() {
        val room = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(7, Solution().numberOfCleanRooms(room))
    }

    @Test
    fun testExample2() {
        val room = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertEquals(1, Solution().numberOfCleanRooms(room))
    }

    @Test
    fun testOpenRoom() {
        val room = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(4, Solution().numberOfCleanRooms(room))
    }

    @Test
    fun testSingleCell() {
        assertEquals(1, Solution().numberOfCleanRooms(arrayOf(intArrayOf(0))))
    }
}
