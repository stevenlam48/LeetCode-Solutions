package designskiplist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DesignSkiplistTest {
    @Test
    fun testExample() {
        val skiplist = Skiplist()
        skiplist.add(1)
        skiplist.add(2)
        skiplist.add(3)
        assertFalse(skiplist.search(0))
        assertFalse(skiplist.erase(0))
        assertTrue(skiplist.erase(1))
        assertFalse(skiplist.search(1))
        assertTrue(skiplist.search(2))
        assertTrue(skiplist.search(3))
    }

    @Test
    fun testEmpty() {
        val skiplist = Skiplist()
        assertFalse(skiplist.search(1))
        assertFalse(skiplist.erase(1))
        assertEquals(0, skiplist.size())
    }

    @Test
    fun testDuplicates() {
        val skiplist = Skiplist()
        skiplist.add(5)
        skiplist.add(5)
        skiplist.add(5)
        assertEquals(3, skiplist.size())
        assertTrue(skiplist.erase(5))
        assertTrue(skiplist.search(5))
        assertEquals(2, skiplist.size())
        assertTrue(skiplist.erase(5))
        assertTrue(skiplist.erase(5))
        assertFalse(skiplist.search(5))
        assertEquals(0, skiplist.size())
    }

    @Test
    fun testNegativeValues() {
        val skiplist = Skiplist()
        skiplist.add(-10)
        skiplist.add(0)
        skiplist.add(10)
        assertTrue(skiplist.search(-10))
        assertTrue(skiplist.search(0))
        assertTrue(skiplist.search(10))
        assertFalse(skiplist.search(-5))
        assertTrue(skiplist.erase(-10))
        assertFalse(skiplist.search(-10))
    }

    @Test
    fun testAgainstTreeSet() {
        val skiplist = Skiplist()
        val reference = java.util.TreeMap<Int, Int>()
        val random = java.util.Random(42)
        var expectedSize = 0
        repeat(2000) {
            val value = random.nextInt(500) - 250
            when (random.nextInt(3)) {
                0 -> {
                    skiplist.add(value)
                    reference[value] = reference.getOrDefault(value, 0) + 1
                    ++expectedSize
                }
                1 -> {
                    val count = reference.getOrDefault(value, 0)
                    assertEquals(count > 0, skiplist.erase(value))
                    if (count > 0) {
                        --expectedSize
                    }
                    if (count > 1) {
                        reference[value] = count - 1
                    } else {
                        reference.remove(value)
                    }
                }
                else -> {
                    assertEquals(reference.containsKey(value), skiplist.search(value))
                }
            }
            assertEquals(expectedSize, skiplist.size())
        }
    }
}
