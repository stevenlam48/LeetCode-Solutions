package spiralmatrixiv

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpiralMatrixIVTest {
    @Test
    fun singleRow() {
        val expected = arrayOf(intArrayOf(0, 1, 2, -1))
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrix(1, 4, makeList(0, 1, 2, -1))))
    }

    @Test
    fun twoByTwo() {
        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 3)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrix(2, 2, makeList(1, 2, 3, 4))))
    }

    @Test
    fun partialFill() {
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(-1, -1, 4)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrix(2, 3, makeList(1, 2, 3, 4))))
    }

    @Test
    fun fullThreeByThree() {
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(8, 9, 4),
            intArrayOf(7, 6, 5)
        )
        assertTrue(expected.contentDeepEquals(Solution().spiralMatrix(3, 3, makeList(1, 2, 3, 4, 5, 6, 7, 8, 9))))
    }
}

private fun makeList(vararg v: Int): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    for (x in v) {
        curr.next = ListNode(x)
        curr = curr.next!!
    }
    return dummy.next
}
