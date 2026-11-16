package firstmissingpositive

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstMissingPositiveTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().firstMissingPositive(intArrayOf(1, 2, 0)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    }

    @Test
    fun singleOne() {
        assertEquals(2, Solution().firstMissingPositive(intArrayOf(1)))
    }

    @Test
    fun empty() {
        assertEquals(1, Solution().firstMissingPositive(intArrayOf()))
    }

    @Test
    fun duplicates() {
        assertEquals(2, Solution().firstMissingPositive(intArrayOf(1, 1)))
    }
}
