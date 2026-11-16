package hindexii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HIndexIiTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().hIndex(intArrayOf(0, 1, 3, 5, 6)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().hIndex(intArrayOf(1, 2, 100)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().hIndex(intArrayOf(0)))
    }

    @Test
    fun singleLarge() {
        assertEquals(1, Solution().hIndex(intArrayOf(100)))
    }

    @Test
    fun allZero() {
        assertEquals(0, Solution().hIndex(intArrayOf(0, 0)))
    }

    @Test
    fun allHundred() {
        assertEquals(3, Solution().hIndex(intArrayOf(100, 100, 100)))
    }
}
