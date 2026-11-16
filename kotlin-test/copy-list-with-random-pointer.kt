package copylistwithrandompointer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class CopyListWithRandomPointerTest {
    private val solution = Solution()

    private fun build(values: IntArray, randoms: IntArray): Node? {
        if (values.isEmpty()) return null
        val nodes = values.map { Node(it) }
        for (i in nodes.indices) {
            if (i + 1 < nodes.size) {
                nodes[i].next = nodes[i + 1]
            }
            if (randoms[i] >= 0) {
                nodes[i].random = nodes[randoms[i]]
            }
        }
        return nodes[0]
    }

    private fun toValues(head: Node?): List<Int> {
        val result = mutableListOf<Int>()
        var curr = head
        while (curr != null) {
            result.add(curr.`val`)
            curr = curr.next
        }
        return result
    }

    private fun toRandomIndices(head: Node?): List<Int> {
        val nodes = mutableListOf<Node>()
        var curr = head
        while (curr != null) {
            nodes.add(curr)
            curr = curr.next
        }
        val index = nodes.withIndex().associate { (i, n) -> n to i }
        return nodes.map { node -> node.random?.let { index[it] } ?: -1 }
    }

    @Test
    fun testExample() {
        val head = build(intArrayOf(7, 13, 11, 10, 1), intArrayOf(-1, 0, 4, 2, 0))
        val copy = solution.copyRandomList(head)
        assertEquals(listOf(7, 13, 11, 10, 1), toValues(copy))
        assertEquals(listOf(-1, 0, 4, 2, 0), toRandomIndices(copy))
        assertNotSame(head, copy)
        var a = head
        var b = copy
        while (a != null && b != null) {
            assertNotSame(a, b)
            a = a.next
            b = b.next
        }
    }

    @Test
    fun testEmpty() {
        assertNull(solution.copyRandomList(null))
    }

    @Test
    fun testSingleSelfRandom() {
        val head = build(intArrayOf(5), intArrayOf(0))
        val copy = solution.copyRandomList(head)
        assertEquals(listOf(5), toValues(copy))
        assertSame(copy, copy!!.random)
        assertNotSame(head, copy)
    }
}
