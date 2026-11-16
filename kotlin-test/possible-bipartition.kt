package possiblebipartition

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PossibleBipartitionTest {
    @Test
    fun bipartiteDislikeGraph() {
        assertTrue(
            Solution().possibleBipartition(
                4,
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))
            )
        )
    }

    @Test
    fun oddLengthCycle() {
        assertFalse(
            Solution().possibleBipartition(
                3,
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun noDislikes() {
        assertTrue(Solution().possibleBipartition(3, emptyArray()))
    }

    @Test
    fun mutuallyDislikingPair() {
        assertTrue(Solution().possibleBipartition(2, arrayOf(intArrayOf(1, 2))))
    }
}
