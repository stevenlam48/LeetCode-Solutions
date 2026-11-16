package minimumscoreafterremovalsonatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreAfterRemovalsOnATreeTest {
    @Test
    fun example1() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4)
        )
        assertEquals(9, Solution().minimumScore(intArrayOf(1, 5, 5, 4, 11), edges))
    }

    @Test
    fun smallPath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(2, Solution().minimumScore(intArrayOf(1, 2, 3), edges))
    }

    @Test
    fun equalValues() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(0, Solution().minimumScore(intArrayOf(1, 1, 1), edges))
    }

    @Test
    fun star() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )
        assertEquals(5, Solution().minimumScore(intArrayOf(1, 2, 4, 8), edges))
    }
}
