package hindex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HIndexTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().hIndex(intArrayOf(3, 0, 6, 1, 5)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().hIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun emptyCitations() {
        assertEquals(0, Solution().hIndex(intArrayOf()))
    }

    @Test
    fun allZero() {
        assertEquals(0, Solution().hIndex(intArrayOf(0, 0, 0)))
    }

    @Test
    fun oneLargeCitation() {
        assertEquals(1, Solution().hIndex(intArrayOf(100)))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().hIndex(intArrayOf(1, 1)))
    }
}
