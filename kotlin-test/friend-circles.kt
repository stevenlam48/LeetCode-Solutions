package friendcircles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FriendCirclesTest {
    @Test
    fun example1() {
        val M = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(2, Solution().findCircleNum(M))
    }

    @Test
    fun example2() {
        val M = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, Solution().findCircleNum(M))
    }

    @Test
    fun singleStudent() {
        assertEquals(1, Solution().findCircleNum(arrayOf(intArrayOf(1))))
    }

    @Test
    fun allConnectedThroughChain() {
        val M = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(0, 0, 1, 1)
        )
        assertEquals(1, Solution().findCircleNum(M))
    }
}
