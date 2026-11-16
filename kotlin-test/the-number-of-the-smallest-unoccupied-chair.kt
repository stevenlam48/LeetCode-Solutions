package thenumberofthesmallestunoccupiedchair

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfTheSmallestUnoccupiedChairTest {

    @Test
    fun testExample1() {
        val times = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3),
            intArrayOf(4, 6)
        )
        assertEquals(1, Solution().smallestChair(times, 1))
    }

    @Test
    fun testExample2() {
        val times = arrayOf(
            intArrayOf(3, 10),
            intArrayOf(1, 5),
            intArrayOf(2, 6)
        )
        assertEquals(2, Solution().smallestChair(times, 0))
    }

    @Test
    fun testSingleFriend() {
        val times = arrayOf(intArrayOf(1, 2))
        assertEquals(0, Solution().smallestChair(times, 0))
    }

    @Test
    fun testChairReuse() {
        val times = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(0, Solution().smallestChair(times, 2))
    }

    @Test
    fun testAllOverlap() {
        val times = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 10),
            intArrayOf(3, 10)
        )
        assertEquals(2, Solution().smallestChair(times, 2))
    }
}
