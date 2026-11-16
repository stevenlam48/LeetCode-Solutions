package insertintoasortedcircularlinkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class InsertIntoASortedCircularLinkedListTest {
    @Test
    fun createsSingleNodeCycle() {
        val head = Solution().insert(null, 1)
        assertSame(head, head.next)
        assertEquals(listOf(1), toList(head, 1))
    }

    @Test
    fun insertsBetweenTwoNodes() {
        val head = circularOf(3, 4, 1)
        assertSame(head, Solution().insert(head, 2))
        assertEquals(listOf(3, 4, 1, 2), toList(head, 4))
    }

    @Test
    fun insertsAtRotationBoundary() {
        val high = circularOf(3, 4, 1)
        Solution().insert(high, 5)
        assertEquals(listOf(3, 4, 5, 1), toList(high, 4))
        val low = circularOf(3, 4, 1)
        Solution().insert(low, 0)
        assertEquals(listOf(3, 4, 0, 1), toList(low, 4))
    }

    @Test
    fun handlesUniformListAndSingleNode() {
        val head = circularOf(1, 1, 1)
        Solution().insert(head, 1)
        assertEquals(listOf(1, 1, 1, 1), toList(head, 4))
        val single = circularOf(3)
        Solution().insert(single, 2)
        assertEquals(listOf(3, 2), toList(single, 2))
    }
}

private fun circularOf(vararg values: Int): Node? {
    if (values.isEmpty()) return null
    val head = Node(values[0])
    var tail = head
    for (i in 1 until values.size) {
        tail.next = Node(values[i])
        tail = tail.next!!
    }
    tail.next = head
    return head
}

private fun toList(head: Node?, size: Int): List<Int> {
    val result = mutableListOf<Int>()
    var current = head
    repeat(size) {
        result.add(current!!.`val`)
        current = current.next
    }
    return result
}
