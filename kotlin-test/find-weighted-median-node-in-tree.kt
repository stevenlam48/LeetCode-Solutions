package findweightedmediannodeintree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindWeightedMedianNodeInTreeTest {
    @Test
    fun findsMedianInBothDirectionsOnAWeightedPath() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 2)
        )

        assertArrayEquals(intArrayOf(2, 1, 1, 0, 2), Solution().findMedian(3, edges, queries))
    }

    @Test
    fun selectsMedianAcrossBranches() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(0, 2, 1),
            intArrayOf(0, 3, 2)
        )
        val queries = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 2),
            intArrayOf(2, 3)
        )

        assertArrayEquals(intArrayOf(0, 1, 0, 1, 0, 3), Solution().findMedian(4, edges, queries))
    }

    @Test
    fun handlesExactHalfOfThePathWeight() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 2))
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(2, 0))

        assertArrayEquals(intArrayOf(1, 1), Solution().findMedian(3, edges, queries))
    }

    @Test
    fun handlesSingleNodeAndIdenticalEndpoints() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findMedian(1, emptyArray(), arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
        )
    }
}
