package designcompressedstringiterator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignCompressedStringIteratorTest {
    @Test
    fun leetCodeExample() {
        val iterator = StringIterator("L1e2t1C1o1d1e1")
        assertEquals('L', iterator.next())
        assertEquals('e', iterator.next())
        assertEquals('e', iterator.next())
        assertEquals('t', iterator.next())
        assertEquals('C', iterator.next())
        assertEquals('o', iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals('d', iterator.next())
        assertEquals('e', iterator.next())
        assertFalse(iterator.hasNext())
        assertEquals(' ', iterator.next())
    }

    @Test
    fun multiDigitRunLength() {
        val iterator = StringIterator("a12b3")
        repeat(12) {
            assertTrue(iterator.hasNext())
            assertEquals('a', iterator.next())
        }
        repeat(3) { assertEquals('b', iterator.next()) }
        assertFalse(iterator.hasNext())
    }

    @Test
    fun emptyString() {
        val iterator = StringIterator("")
        assertFalse(iterator.hasNext())
        assertEquals(' ', iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun adjacentSingleCharacters() {
        val iterator = StringIterator("x1y1z1")
        assertEquals('x', iterator.next())
        assertEquals('y', iterator.next())
        assertEquals('z', iterator.next())
        assertFalse(iterator.hasNext())
        assertEquals(' ', iterator.next())
    }
}
