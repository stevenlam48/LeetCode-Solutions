package designanumbercontainersystem

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignANumberContainerSystemTest {
    @Test
    fun testExample() {
        val nc = NumberContainers()
        assertEquals(-1, nc.find(10))
        nc.change(1, 10)
        assertEquals(1, nc.find(10))
        nc.change(2, 10)
        assertEquals(1, nc.find(10))
        nc.change(1, 20)
        assertEquals(2, nc.find(10))
        assertEquals(1, nc.find(20))
        assertEquals(-1, nc.find(30))
    }

    @Test
    fun testChangeSameIndex() {
        val nc = NumberContainers()
        nc.change(5, 1)
        nc.change(5, 2)
        assertEquals(-1, nc.find(1))
        assertEquals(5, nc.find(2))
    }

    @Test
    fun testMultipleIndices() {
        val nc = NumberContainers()
        nc.change(3, 7)
        nc.change(1, 7)
        nc.change(2, 7)
        assertEquals(1, nc.find(7))
    }

    @Test
    fun testFindUnknown() {
        val nc = NumberContainers()
        assertEquals(-1, nc.find(99))
    }
}
