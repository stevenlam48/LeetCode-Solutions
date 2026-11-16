package designmemoryallocator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignMemoryAllocatorTest {
    @Test
    fun leetCodeExample() {
        val allocator = Allocator(10)
        assertEquals(0, allocator.allocate(1, 1))
        assertEquals(1, allocator.allocate(1, 2))
        assertEquals(2, allocator.allocate(1, 3))
        assertEquals(1, allocator.free(2))
        assertEquals(3, allocator.allocate(3, 4))
        assertEquals(1, allocator.allocate(1, 1))
        assertEquals(6, allocator.allocate(1, 1))
        assertEquals(3, allocator.free(1))
        assertEquals(-1, allocator.allocate(10, 2))
        assertEquals(0, allocator.free(7))
    }

    @Test
    fun allocationFailsWhenNoSingleBlockIsLargeEnough() {
        val allocator = Allocator(6)
        assertEquals(0, allocator.allocate(2, 1))
        assertEquals(2, allocator.allocate(2, 2))
        assertEquals(4, allocator.allocate(2, 3))
        assertEquals(-1, allocator.allocate(1, 4))
        assertEquals(2, allocator.free(2))
        assertEquals(-1, allocator.allocate(3, 4))
        assertEquals(2, allocator.allocate(2, 4))
    }

    @Test
    fun freeingMergesBothAdjacentBlocks() {
        val allocator = Allocator(10)
        assertEquals(0, allocator.allocate(3, 1))
        assertEquals(3, allocator.allocate(4, 2))
        assertEquals(7, allocator.allocate(3, 3))
        allocator.free(1)
        allocator.free(3)
        assertEquals(4, allocator.free(2))
        assertEquals(0, allocator.allocate(10, 4))
    }

    @Test
    fun repeatedFreeReturnsZero() {
        val allocator = Allocator(4)
        allocator.allocate(4, 8)
        assertEquals(4, allocator.free(8))
        assertEquals(0, allocator.free(8))
        assertEquals(0, allocator.allocate(4, 9))
    }
}
