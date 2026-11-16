package printimmutablelinkedlistinreverse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrintImmutableLinkedListInReverseTest {
    @Test
    fun fiveNodes() {
        val output = mutableListOf<Int>()
        Solution().printLinkedListInReverse(build(intArrayOf(1, 2, 3, 4, 5), output))
        assertEquals(listOf(5, 4, 3, 2, 1), output)
    }

    @Test
    fun singleNode() {
        val output = mutableListOf<Int>()
        Solution().printLinkedListInReverse(build(intArrayOf(7), output))
        assertEquals(listOf(7), output)
    }

    @Test
    fun emptyList() {
        val output = mutableListOf<Int>()
        Solution().printLinkedListInReverse(build(intArrayOf(), output))
        assertEquals(emptyList<Int>(), output)
    }

    @Test
    fun tenNodes() {
        val output = mutableListOf<Int>()
        Solution().printLinkedListInReverse(build(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), output))
        assertEquals(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), output)
    }
}

private class RecordingNode(value: Int, next: ImmutableListNode?, private val output: MutableList<Int>) :
    ImmutableListNode(value, next) {
    override fun printValue() {
        output.add(value)
    }
}

private fun build(values: IntArray, output: MutableList<Int>): ImmutableListNode? {
    var head: ImmutableListNode? = null
    for (i in values.indices.reversed()) {
        head = RecordingNode(values[i], head, output)
    }
    return head
}
