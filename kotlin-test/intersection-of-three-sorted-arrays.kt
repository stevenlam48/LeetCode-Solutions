package intersectionofthreesortedarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionOfThreeSortedArraysTest {
    @Test
    fun solvesLeetCodeExample() {
        assertArrayEquals(
            intArrayOf(1, 5),
            Solution().arraysIntersection(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(1, 2, 5, 7, 9),
                intArrayOf(1, 3, 4, 5, 8)
            )
        )
    }

    @Test
    fun retainsCommonDuplicates() {
        assertArrayEquals(
            intArrayOf(2, 2, 4),
            Solution().arraysIntersection(
                intArrayOf(1, 2, 2, 4, 8),
                intArrayOf(2, 2, 4, 5),
                intArrayOf(2, 2, 3, 4)
            )
        )
    }

    @Test
    fun returnsEmptyWhenNoValueIsCommon() {
        assertArrayEquals(
            IntArray(0),
            Solution().arraysIntersection(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
        )
    }

    @Test
    fun handlesEmptyArrays() {
        assertArrayEquals(IntArray(0), Solution().arraysIntersection(IntArray(0), intArrayOf(1), intArrayOf(1)))
    }
}
