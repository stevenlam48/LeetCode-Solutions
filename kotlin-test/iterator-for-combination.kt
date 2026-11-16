package iteratorforcombination

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IteratorForCombinationTest {
    @Test
    fun testExample() {
        val it = CombinationIterator("abc", 2)
        assertTrue(it.hasNext())
        assertEquals("ab", it.next())
        assertTrue(it.hasNext())
        assertEquals("ac", it.next())
        assertTrue(it.hasNext())
        assertEquals("bc", it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun testLengthThree() {
        val it = CombinationIterator("abcd", 3)
        assertEquals(listOf("abc", "abd", "acd", "bcd"), drain(it))
    }

    @Test
    fun testSingleCharacter() {
        val it = CombinationIterator("a", 1)
        assertTrue(it.hasNext())
        assertEquals("a", it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun testFullLength() {
        val it = CombinationIterator("abc", 3)
        assertTrue(it.hasNext())
        assertEquals("abc", it.next())
        assertFalse(it.hasNext())
    }

    private fun drain(it: CombinationIterator): List<String> {
        val result = mutableListOf<String>()
        while (it.hasNext()) {
            result.add(it.next())
        }
        return result
    }
}
