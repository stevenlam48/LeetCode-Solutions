package flattenamultileveldoublylinkedlist

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class FlattenAMultilevelDoublyLinkedListTest {
    @Test
    fun leetCodeExample() {
        val head = linkedListOf(1, 2, 3, 4, 5, 6)!!
        val node3 = head.next!!.next!!
        val child = linkedListOf(7, 8, 9, 10)!!
        node3.child = child
        val node8 = child.next!!
        node8.child = linkedListOf(11, 12)!!

        val result = Solution().flatten(head)

        assertArrayEquals(intArrayOf(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6), toArray(result))
        assertPrevLinks(result)
    }

    @Test
    fun childAtHead() {
        val head = linkedListOf(1, 2)!!
        head.child = linkedListOf(3)!!

        val result = Solution().flatten(head)

        assertArrayEquals(intArrayOf(1, 3, 2), toArray(result))
        assertPrevLinks(result)
    }

    @Test
    fun noChildren() {
        val head = linkedListOf(1, 2, 3)!!

        val result = Solution().flatten(head)

        assertArrayEquals(intArrayOf(1, 2, 3), toArray(result))
        assertPrevLinks(result)
    }

    @Test
    fun singleNode() {
        val head = linkedListOf(1)!!

        val result = Solution().flatten(head)

        assertArrayEquals(intArrayOf(1), toArray(result))
        assertNull(result!!.prev)
    }

    @Test
    fun emptyList() {
        assertNull(Solution().flatten(null))
    }

    private fun linkedListOf(vararg values: Int): Node? {
        if (values.isEmpty()) {
            return null
        }
        val nodes = values.map { Node(it) }
        for (i in 1 until nodes.size) {
            nodes[i - 1].next = nodes[i]
            nodes[i].prev = nodes[i - 1]
        }
        return nodes[0]
    }

    private fun toArray(head: Node?): IntArray {
        val result = mutableListOf<Int>()
        var curr = head
        while (curr != null) {
            result.add(curr.`val`)
            curr = curr.next
        }
        return result.toIntArray()
    }

    private fun assertPrevLinks(head: Node?) {
        var prev: Node? = null
        var curr = head
        while (curr != null) {
            assertSame(prev, curr.prev)
            prev = curr
            curr = curr.next
        }
    }
}
