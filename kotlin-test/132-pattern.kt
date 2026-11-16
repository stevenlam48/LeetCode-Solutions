package p132pattern

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class P132patternTest {
    @Test
    fun example1() {
        assertFalse(Solution().find132pattern(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertTrue(Solution().find132pattern(intArrayOf(3, 1, 4, 2)))
    }

    @Test
    fun example3() {
        assertTrue(Solution().find132pattern(intArrayOf(-1, 3, 2, 0)))
    }

    @Test
    fun tooShort() {
        assertFalse(Solution().find132pattern(intArrayOf(1, 2)))
        assertFalse(Solution().find132pattern(intArrayOf(1)))
    }

    @Test
    fun duplicates() {
        assertFalse(Solution().find132pattern(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun patternAtEnd() {
        assertTrue(Solution().find132pattern(intArrayOf(1, 0, 1, 3, 2)))
    }
}
