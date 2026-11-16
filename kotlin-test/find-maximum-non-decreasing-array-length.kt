package findmaximumnondecreasingarraylength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumNonDecreasingArrayLengthTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().findMaximumLength(intArrayOf(5, 2, 2)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().findMaximumLength(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().findMaximumLength(intArrayOf(4, 3, 2, 6)))
    }

    @Test
    fun allOnes() {
        assertEquals(5, Solution().findMaximumLength(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().findMaximumLength(intArrayOf(10)))
    }

    @Test
    fun decreasing() {
        assertEquals(2, Solution().findMaximumLength(intArrayOf(5, 4, 3, 2, 1)))
    }
}
