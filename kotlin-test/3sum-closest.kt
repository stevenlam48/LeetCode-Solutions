package p3sumclosest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P3sumclosestTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().threeSumClosest(intArrayOf(0, 0, 0), 1))
    }

    @Test
    fun exactMatch() {
        assertEquals(0, Solution().threeSumClosest(intArrayOf(-1, 0, 1, 2), 0))
    }

    @Test
    fun allPositive() {
        assertEquals(6, Solution().threeSumClosest(intArrayOf(1, 2, 3), 100))
    }

    @Test
    fun negatives() {
        assertEquals(-6, Solution().threeSumClosest(intArrayOf(-1, -2, -3), -100))
    }
}
