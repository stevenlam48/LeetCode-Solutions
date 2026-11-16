package kthlargestelementinastream

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestElementInAStreamTest {
    @Test
    fun example1() {
        val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2))
        assertEquals(4, kthLargest.add(3))
        assertEquals(5, kthLargest.add(5))
        assertEquals(5, kthLargest.add(10))
        assertEquals(8, kthLargest.add(9))
        assertEquals(8, kthLargest.add(4))
    }

    @Test
    fun kEqualsOne() {
        val kthLargest = KthLargest(1, intArrayOf())
        assertEquals(-3, kthLargest.add(-3))
        assertEquals(-2, kthLargest.add(-2))
        assertEquals(-2, kthLargest.add(-4))
        assertEquals(0, kthLargest.add(0))
        assertEquals(4, kthLargest.add(4))
    }

    @Test
    fun kEqualsTwo() {
        val kthLargest = KthLargest(2, intArrayOf(0))
        assertEquals(-1, kthLargest.add(-1))
        assertEquals(0, kthLargest.add(1))
        assertEquals(0, kthLargest.add(-2))
        assertEquals(0, kthLargest.add(-4))
        assertEquals(1, kthLargest.add(3))
    }

    @Test
    fun duplicates() {
        val kthLargest = KthLargest(2, intArrayOf(5, 5, 5))
        assertEquals(5, kthLargest.add(5))
        assertEquals(5, kthLargest.add(1))
    }
}
