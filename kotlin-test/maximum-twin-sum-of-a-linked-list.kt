package maximumtwinsumofalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTwinSumOfALinkedListTest {
    @Test
    fun examples() {
        assertEquals(6, Solution().pairSum(listOf(5, 4, 2, 1)))
        assertEquals(7, Solution().pairSum(listOf(4, 2, 2, 3)))
    }

    @Test
    fun twoNodes() {
        assertEquals(100001, Solution().pairSum(listOf(1, 100000)))
    }

    @Test
    fun longestTwinPairWins() {
        assertEquals(31, Solution().pairSum(listOf(1, 2, 3, 10, 20, 30)))
    }
}

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in values) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }
    return dummy.next
}
