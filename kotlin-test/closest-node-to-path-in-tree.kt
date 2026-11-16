package closestnodetopathintree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClosestNodeToPathInTreeTest {
    @Test
    fun branchingTreeQueries() {
        assertArrayEquals(
            intArrayOf(2, 2),
            Solution().closestNode(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6)
                ),
                arrayOf(intArrayOf(5, 3, 2), intArrayOf(5, 3, 6))
            )
        )
    }

    @Test
    fun targetLiesOnPath() {
        assertArrayEquals(
            intArrayOf(1, 1, 0),
            Solution().closestNode(
                3,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)),
                arrayOf(intArrayOf(0, 1, 2), intArrayOf(0, 2, 1), intArrayOf(0, 2, 0))
            )
        )
    }

    @Test
    fun pathHasOneRepeatedEndpoint() {
        assertArrayEquals(
            intArrayOf(4),
            Solution().closestNode(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6)
                ),
                arrayOf(intArrayOf(4, 4, 5))
            )
        )
    }

    @Test
    fun singleNodeTree() {
        assertArrayEquals(intArrayOf(0), Solution().closestNode(1, emptyArray(), arrayOf(intArrayOf(0, 0, 0))))
    }

    @Test
    fun repeatedQueriesReuseOfflineLcas() {
        assertArrayEquals(
            intArrayOf(2, 2, 0),
            Solution().closestNode(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6)
                ),
                arrayOf(intArrayOf(5, 3, 2), intArrayOf(3, 5, 2), intArrayOf(4, 6, 3))
            )
        )
    }
}
