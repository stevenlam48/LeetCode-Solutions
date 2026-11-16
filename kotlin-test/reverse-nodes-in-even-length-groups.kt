package reversenodesinevenlengthgroups

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseNodesInEvenLengthGroupsTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(1, 3, 2, 4, 5, 6), toArray(Solution().reverseEvenLengthGroups(listOf(1, 2, 3, 4, 5, 6))))
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(1, 0, 1, 6), toArray(Solution().reverseEvenLengthGroups(listOf(1, 1, 0, 6))))
    }

    @Test
    fun oddFinalGroupIsUnchanged() {
        assertArrayEquals(intArrayOf(1, 3, 2, 4), toArray(Solution().reverseEvenLengthGroups(listOf(1, 2, 3, 4))))
    }

    @Test
    fun emptyList() {
        assertArrayEquals(intArrayOf(), toArray(Solution().reverseEvenLengthGroups(null)))
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

private fun toArray(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var node = head
    while (node != null) {
        result.add(node.`val`)
        node = node.next
    }
    return result.toIntArray()
}
