package findtheminimumandmaximumnumberofnodesbetweencriticalpoints

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

private fun listOf(vararg v: Int): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (x in v) {
        tail.next = ListNode(x)
        tail = tail.next!!
    }
    return dummy.next
}

class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPointsTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().nodesBetweenCriticalPoints(listOf(3, 1))
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 3),
            Solution().nodesBetweenCriticalPoints(listOf(5, 3, 1, 2, 5, 1, 2))
        )
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(3, 3),
            Solution().nodesBetweenCriticalPoints(listOf(1, 3, 2, 2, 3, 2, 2, 2, 7))
        )
    }

    @Test
    fun noCriticalPoints() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            Solution().nodesBetweenCriticalPoints(listOf(1, 2, 3, 4))
        )
    }
}
