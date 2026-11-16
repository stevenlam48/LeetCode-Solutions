package mergestringsalternately

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeStringsAlternatelyTest {
    @Test
    fun example1() {
        assertEquals("apbqcr", Solution().mergeAlternately("abc", "pqr"))
    }

    @Test
    fun example2() {
        assertEquals("apbqrs", Solution().mergeAlternately("ab", "pqrs"))
    }

    @Test
    fun example3() {
        assertEquals("apbqcd", Solution().mergeAlternately("abcd", "pq"))
    }

    @Test
    fun firstEmpty() {
        assertEquals("abc", Solution().mergeAlternately("", "abc"))
    }

    @Test
    fun secondEmpty() {
        assertEquals("abc", Solution().mergeAlternately("abc", ""))
    }

    @Test
    fun bothEmpty() {
        assertEquals("", Solution().mergeAlternately("", ""))
    }
}
