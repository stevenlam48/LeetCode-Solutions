package twobestnonoverlappingevents

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TwoBestNonOverlappingEventsTest {
    @Test
    fun standardExamples() {
        assertEquals(4, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 3, 2), intArrayOf(4, 5, 2), intArrayOf(2, 4, 3))))
        assertEquals(5, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 3, 2), intArrayOf(4, 5, 2), intArrayOf(1, 5, 5))))
        assertEquals(8, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 5, 3), intArrayOf(1, 5, 1), intArrayOf(6, 6, 5))))
    }

    @Test
    fun touchingEndpointsCannotBePaired() {
        assertEquals(4, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 4, 4))))
        assertEquals(7, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 4, 4))))
    }

    @Test
    fun singleAndUnsortedEvents() {
        assertEquals(9, Solution().maxTwoEvents(arrayOf(intArrayOf(1, 2, 9))))
        assertEquals(10, Solution().maxTwoEvents(arrayOf(intArrayOf(5, 6, 6), intArrayOf(1, 2, 4), intArrayOf(3, 4, 3))))
    }
}
