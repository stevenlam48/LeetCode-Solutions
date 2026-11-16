package findbuildingwherealiceandbobcanmeet

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindBuildingWhereAliceAndBobCanMeetTest {
    @Test
    fun firstLeetCodeExample() {
        val queries = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 3), intArrayOf(2, 4),
            intArrayOf(3, 4), intArrayOf(2, 2)
        )
        assertArrayEquals(
            intArrayOf(2, 5, -1, 5, 2),
            Solution().leftmostBuildingQueries(intArrayOf(6, 4, 8, 5, 2, 7), queries)
        )
    }

    @Test
    fun secondLeetCodeExample() {
        val queries = arrayOf(
            intArrayOf(0, 7), intArrayOf(3, 5), intArrayOf(5, 2),
            intArrayOf(3, 0), intArrayOf(1, 6)
        )
        assertArrayEquals(
            intArrayOf(7, 6, -1, 4, 6),
            Solution().leftmostBuildingQueries(intArrayOf(5, 3, 8, 2, 6, 1, 4, 6), queries)
        )
    }

    @Test
    fun singleBuildingAndNoLaterCandidate() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().leftmostBuildingQueries(intArrayOf(10), arrayOf(intArrayOf(0, 0)))
        )
        assertArrayEquals(
            intArrayOf(-1),
            Solution().leftmostBuildingQueries(intArrayOf(5, 4), arrayOf(intArrayOf(0, 1)))
        )
    }
}
