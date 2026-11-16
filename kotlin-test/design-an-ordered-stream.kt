package designanorderedstream

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAnOrderedStreamTest {
    @Test
    fun testExample() {
        val stream = OrderedStream(5)
        assertEquals(emptyList<String>(), stream.insert(3, "ccccc"))
        assertEquals(listOf("aaaaa"), stream.insert(1, "aaaaa"))
        assertEquals(listOf("bbbbb", "ccccc"), stream.insert(2, "bbbbb"))
        assertEquals(emptyList<String>(), stream.insert(5, "eeeee"))
        assertEquals(listOf("ddddd", "eeeee"), stream.insert(4, "ddddd"))
    }

    @Test
    fun testSequentialInserts() {
        val stream = OrderedStream(3)
        assertEquals(listOf("a"), stream.insert(1, "a"))
        assertEquals(listOf("b"), stream.insert(2, "b"))
        assertEquals(listOf("c"), stream.insert(3, "c"))
    }

    @Test
    fun testOutOfOrder() {
        val stream = OrderedStream(3)
        assertEquals(emptyList<String>(), stream.insert(2, "b"))
        assertEquals(emptyList<String>(), stream.insert(3, "c"))
        assertEquals(listOf("a", "b", "c"), stream.insert(1, "a"))
    }

    @Test
    fun testSingleElement() {
        val stream = OrderedStream(1)
        assertEquals(listOf("x"), stream.insert(1, "x"))
    }
}
