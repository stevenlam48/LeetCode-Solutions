package linkedlistcycleii

import common.ListNode
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class LinkedListCycleIiTest {
    @Test
    fun noCycle() {
        assertNull(Solution().detectCycle(listOf(1, 2, 3)))
    }

    @Test
    fun cycleAtHead() {
        val head = cyclicListOf(0, 1, 2, 3)
        assertSame(head, Solution().detectCycle(head))
    }

    @Test
    fun cycleInMiddle() {
        val head = cyclicListOf(2, 1, 2, 3, 4)
        val expected = head!!.next!!.next
        assertSame(expected, Solution().detectCycle(head))
    }

    @Test
    fun singleNodeWithoutCycle() {
        assertNull(Solution().detectCycle(listOf(1)))
    }

    @Test
    fun singleNodeWithCycle() {
        val head = cyclicListOf(0, 1)
        assertSame(head, Solution().detectCycle(head))
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

private fun cyclicListOf(entry: Int, vararg values: Int): ListNode? {
    val head = listOf(*values)
    if (head == null || entry < 0) {
        return head
    }
    var cycleEntry = head!!
    repeat(entry) {
        cycleEntry = cycleEntry.next!!
    }
    var tail = head!!
    while (tail.next != null) {
        tail = tail.next!!
    }
    tail.next = cycleEntry
    return head
}
