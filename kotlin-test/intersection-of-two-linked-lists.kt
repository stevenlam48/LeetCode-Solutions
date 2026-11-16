package intersectionoftwolinkedlists

import common.ListNode
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class IntersectionOfTwoLinkedListsTest {
    @Test
    fun findsSharedSuffix() {
        val shared = listOf(8, 4, 5)
        val headA = listOf(4, 1)
        val headB = listOf(5, 6, 1)
        tail(headA).next = shared
        tail(headB).next = shared
        assertSame(shared, Solution().getIntersectionNode(headA, headB))
    }

    @Test
    fun returnsNullForDisjointLists() {
        assertNull(Solution().getIntersectionNode(listOf(2, 6, 4), listOf(1, 5)))
    }

    @Test
    fun handlesListsWithSameHead() {
        val head = listOf(1, 2)
        assertSame(head, Solution().getIntersectionNode(head, head))
    }

    @Test
    fun handlesEmptyInputs() {
        assertNull(Solution().getIntersectionNode(null, listOf(1)))
        assertNull(Solution().getIntersectionNode(null, null))
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

private fun tail(head: ListNode?): ListNode {
    var current = head
    while (current?.next != null) {
        current = current.next
    }
    return current!!
}
