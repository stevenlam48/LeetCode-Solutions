package p3sumsmaller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P3sumsmallerTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().threeSumSmaller(intArrayOf(-2, 0, 1, 3), 2))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().threeSumSmaller(intArrayOf(), 0))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().threeSumSmaller(intArrayOf(0), 0))
    }

    @Test
    fun allTriples() {
        assertEquals(4, Solution().threeSumSmaller(intArrayOf(0, 0, 0, 0), 1))
    }

    @Test
    fun negatives() {
        assertEquals(2, Solution().threeSumSmaller(intArrayOf(-1, 0, 1, 2), 2))
    }
}
