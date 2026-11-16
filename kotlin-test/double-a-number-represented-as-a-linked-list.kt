package doubleanumberrepresentedasalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DoubleANumberRepresentedAsALinkedListTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(3, 7, 8), toArray(Solution().doubleIt(listOf(1, 8, 9))))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(1, 9, 9, 8), toArray(Solution().doubleIt(listOf(9, 9, 9))))
    }

    @Test
    fun zero() {
        assertArrayEquals(intArrayOf(0), toArray(Solution().doubleIt(listOf(0))))
    }

    @Test
    fun singleDigitNeedingCarry() {
        assertArrayEquals(intArrayOf(1, 0), toArray(Solution().doubleIt(listOf(5))))
    }

    @Test
    fun singleDigitNoCarry() {
        assertArrayEquals(intArrayOf(8), toArray(Solution().doubleIt(listOf(4))))
    }

    @Test
    fun emptyList() {
        assertArrayEquals(intArrayOf(), toArray(Solution().doubleIt(null)))
    }
}

private fun listOf(vararg v: Int): ListNode? {
    var head: ListNode? = null
    for (i in v.indices.reversed()) {
        val node = ListNode(v[i])
        node.next = head
        head = node
    }
    return head
}

private fun toArray(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
