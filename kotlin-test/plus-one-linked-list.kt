package plusonelinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

private fun linkedList(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    for (value in values) {
        curr.next = ListNode(value)
        curr = curr.next!!
    }
    return dummy.next
}

private fun values(head: ListNode?): IntArray {
    if (head == null) return IntArray(0)
    val result = mutableListOf<Int>()
    var curr: ListNode? = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}

class PlusOneLinkedListTest {
    @Test
    fun noCarry() {
        assertArrayEquals(intArrayOf(1, 2, 4), values(Solution().plusOne(linkedList(1, 2, 3))))
    }

    @Test
    fun trailingNines() {
        assertArrayEquals(intArrayOf(2, 0, 0), values(Solution().plusOne(linkedList(1, 9, 9))))
    }

    @Test
    fun allNines() {
        assertArrayEquals(intArrayOf(1, 0, 0, 0), values(Solution().plusOne(linkedList(9, 9, 9))))
    }

    @Test
    fun singleZero() {
        assertArrayEquals(intArrayOf(1), values(Solution().plusOne(linkedList(0))))
    }

    @Test
    fun emptyList() {
        assertNull(Solution().plusOne(null))
    }
}
