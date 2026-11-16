package rotatelist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class RotateListTest {
    @Test
    fun leetCodeExample() {
        val head = buildList(1, 2, 3, 4, 5)
        assertArrayEquals(intArrayOf(4, 5, 1, 2, 3), toArray(Solution().rotateRight(head, 2)))
    }

    @Test
    fun shiftLargerThanLength() {
        val head = buildList(0, 1, 2)
        assertArrayEquals(intArrayOf(2, 0, 1), toArray(Solution().rotateRight(head, 4)))
    }

    @Test
    fun zeroShift() {
        val head = buildList(1, 2, 3)
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(Solution().rotateRight(head, 0)))
    }

    @Test
    fun singleNode() {
        val head = buildList(5)
        assertArrayEquals(intArrayOf(5), toArray(Solution().rotateRight(head, 9)))
    }

    @Test
    fun emptyList() {
        assertNull(Solution().rotateRight(null, 3))
    }

    @Test
    fun fullCycleKeepsList() {
        val head = buildList(1, 2)
        assertArrayEquals(intArrayOf(1, 2), toArray(Solution().rotateRight(head, 2)))
    }
}

private fun buildList(vararg v: Int): ListNode? {
    if (v.isEmpty()) {
        return null
    }
    val head = ListNode(v[0])
    var curr = head
    for (i in 1 until v.size) {
        curr.next = ListNode(v[i])
        curr = curr.next!!
    }
    return head
}

private fun toArray(head: ListNode?): IntArray {
    val result = ArrayList<Int>()
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
