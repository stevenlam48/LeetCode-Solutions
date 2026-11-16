package minimizedeviationinarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeDeviationInArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minimumDeviation(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minimumDeviation(intArrayOf(4, 1, 5, 20, 3)))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().minimumDeviation(intArrayOf(2, 10, 8)))
    }

    @Test
    fun equalElements() {
        assertEquals(0, Solution().minimumDeviation(intArrayOf(1, 1)))
    }
}
