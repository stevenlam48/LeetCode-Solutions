package rangemodule

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeModuleTest {
    @Test
    fun testExample() {
        val module = RangeModule()
        module.addRange(10, 20)
        module.removeRange(14, 16)
        assertTrue(module.queryRange(10, 14))
        assertFalse(module.queryRange(13, 15))
        assertTrue(module.queryRange(16, 17))
    }

    @Test
    fun testEmptyModule() {
        val module = RangeModule()
        assertFalse(module.queryRange(0, 1))
    }

    @Test
    fun testMergeOverlapping() {
        val module = RangeModule()
        module.addRange(1, 5)
        module.addRange(3, 8)
        assertTrue(module.queryRange(1, 8))
        assertTrue(module.queryRange(4, 7))
        assertFalse(module.queryRange(0, 1))
    }

    @Test
    fun testRemoveSplitsRange() {
        val module = RangeModule()
        module.addRange(0, 10)
        module.removeRange(4, 6)
        assertTrue(module.queryRange(0, 4))
        assertFalse(module.queryRange(3, 5))
        assertTrue(module.queryRange(6, 10))
        assertFalse(module.queryRange(4, 6))
    }

    @Test
    fun testAdjacentRangesMerge() {
        val module = RangeModule()
        module.addRange(1, 3)
        module.addRange(3, 5)
        assertTrue(module.queryRange(1, 5))
    }
}
