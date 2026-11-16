package designhashmap

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignHashMapTest {
    @Test
    fun putGetOverwriteAndRemove() {
        val map = MyHashMap()
        map.put(1, 1)
        map.put(2, 2)
        assertEquals(1, map.get(1))
        assertEquals(-1, map.get(3))
        map.put(2, 1)
        assertEquals(1, map.get(2))
        map.remove(2)
        assertEquals(-1, map.get(2))
    }

    @Test
    fun collidingKeysRemainIndependent() {
        val map = MyHashMap()
        map.put(1, 10)
        map.put(10001, 20)
        map.put(20001, 30)
        assertEquals(10, map.get(1))
        assertEquals(20, map.get(10001))
        map.remove(10001)
        assertEquals(-1, map.get(10001))
        assertEquals(30, map.get(20001))
        assertEquals(10, map.get(1))
    }

    @Test
    fun removingMissingKeyDoesNothing() {
        val map = MyHashMap()
        map.put(4, 8)
        map.remove(5)
        map.remove(4)
        map.remove(4)
        assertEquals(-1, map.get(4))
    }

    @Test
    fun zeroAndLargeKeys() {
        val map = MyHashMap()
        map.put(0, 7)
        map.put(1_000_000, 9)
        assertEquals(7, map.get(0))
        assertEquals(9, map.get(1_000_000))
    }
}
