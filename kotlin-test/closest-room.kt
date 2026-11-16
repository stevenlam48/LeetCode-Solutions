package closestroom

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ClosestRoomTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val rooms = arrayOf(intArrayOf(2, 2), intArrayOf(1, 2), intArrayOf(3, 2))
        val queries = arrayOf(intArrayOf(3, 1), intArrayOf(3, 3), intArrayOf(5, 2))
        assertArrayEquals(intArrayOf(3, -1, 3), solution.closestRoom(rooms, queries))
    }

    @Test
    fun testExample2() {
        val rooms = arrayOf(
            intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 5),
            intArrayOf(4, 1), intArrayOf(5, 2)
        )
        val queries = arrayOf(intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(2, 5))
        assertArrayEquals(intArrayOf(2, 1, 3), solution.closestRoom(rooms, queries))
    }

    @Test
    fun testNoRoomLargeEnough() {
        val rooms = arrayOf(intArrayOf(1, 1))
        val queries = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(-1), solution.closestRoom(rooms, queries))
    }

    @Test
    fun testExactIdMatch() {
        val rooms = arrayOf(intArrayOf(10, 5), intArrayOf(20, 5))
        val queries = arrayOf(intArrayOf(20, 5), intArrayOf(10, 5))
        assertArrayEquals(intArrayOf(20, 10), solution.closestRoom(rooms, queries))
    }
}
