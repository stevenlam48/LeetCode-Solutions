package gridillumination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GridIlluminationTest {
    @Test
    fun example1() {
        val lamps = arrayOf(intArrayOf(0, 0), intArrayOf(4, 4))
        val queries = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        assertEquals(listOf(1, 0), Solution().gridIllumination(5, lamps, queries))
    }

    @Test
    fun example2() {
        val lamps = arrayOf(intArrayOf(0, 0), intArrayOf(4, 4))
        val queries = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(listOf(1, 1), Solution().gridIllumination(5, lamps, queries))
    }

    @Test
    fun noLamps() {
        val lamps = emptyArray<IntArray>()
        val queries = arrayOf(intArrayOf(1, 1))
        assertEquals(listOf(0), Solution().gridIllumination(3, lamps, queries))
    }

    @Test
    fun lampRemovedAfterQuery() {
        val lamps = arrayOf(intArrayOf(0, 0))
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(listOf(1, 0), Solution().gridIllumination(3, lamps, queries))
    }

    @Test
    fun duplicateLampsCountedOnce() {
        val lamps = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        val queries = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2))
        assertEquals(listOf(1, 0), Solution().gridIllumination(3, lamps, queries))
    }

    @Test
    fun diagonallyIlluminated() {
        val lamps = arrayOf(intArrayOf(2, 0))
        val queries = arrayOf(intArrayOf(0, 2))
        assertEquals(listOf(1), Solution().gridIllumination(3, lamps, queries))
    }
}
