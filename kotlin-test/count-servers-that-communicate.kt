package countserversthatcommunicate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountServersThatCommunicateTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            0,
            solution.countServers(arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)))
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            3,
            solution.countServers(arrayOf(intArrayOf(1, 0), intArrayOf(1, 1)))
        )
    }

    @Test
    fun exampleThree() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1)
        )
        assertEquals(4, solution.countServers(grid))
    }

    @Test
    fun noServers() {
        assertEquals(0, solution.countServers(arrayOf(intArrayOf(0, 0))))
    }
}
