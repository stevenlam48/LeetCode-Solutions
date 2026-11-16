package alloonedatastructure

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllOoneDataStructureTest {
    @Test
    fun testExample1() {
        val allOne = AllOne()
        allOne.inc("a")
        allOne.inc("b")
        allOne.inc("b")
        allOne.inc("c")
        allOne.inc("c")
        allOne.inc("c")
        allOne.dec("b")
        allOne.dec("b")
        assertEquals("a", allOne.getMinKey())
        allOne.dec("a")
        assertEquals("c", allOne.getMaxKey())
        assertEquals("c", allOne.getMinKey())
    }

    @Test
    fun testExample2() {
        val allOne = AllOne()
        allOne.inc("hello")
        allOne.inc("hello")
        assertEquals("hello", allOne.getMaxKey())
        assertEquals("hello", allOne.getMinKey())
        allOne.inc("leet")
        assertEquals("hello", allOne.getMaxKey())
        assertEquals("leet", allOne.getMinKey())
    }

    @Test
    fun testEmpty() {
        val allOne = AllOne()
        assertEquals("", allOne.getMaxKey())
        assertEquals("", allOne.getMinKey())
    }

    @Test
    fun testDecrementToZeroRemovesKey() {
        val allOne = AllOne()
        allOne.inc("x")
        assertEquals("x", allOne.getMaxKey())
        allOne.dec("x")
        assertEquals("", allOne.getMaxKey())
        assertEquals("", allOne.getMinKey())
    }

    @Test
    fun testDecrementUnknownKeyIsNoOp() {
        val allOne = AllOne()
        allOne.inc("a")
        allOne.dec("missing")
        assertEquals("a", allOne.getMaxKey())
        assertEquals("a", allOne.getMinKey())
    }
}
