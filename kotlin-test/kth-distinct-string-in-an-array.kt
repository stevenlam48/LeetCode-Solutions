package kthdistinctstringinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthDistinctStringInAnArrayTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals("a", solution.kthDistinct(listOf("d", "b", "c", "b", "c", "a"), 2))
    }

    @Test
    fun example2() {
        assertEquals("aaa", solution.kthDistinct(listOf("aaa", "aa", "a"), 1))
    }

    @Test
    fun notEnoughDistinct() {
        assertEquals("", solution.kthDistinct(listOf("a", "b", "a"), 3))
    }

    @Test
    fun allDistinct() {
        assertEquals("c", solution.kthDistinct(listOf("a", "b", "c"), 3))
    }

    @Test
    fun singleElement() {
        assertEquals("a", solution.kthDistinct(listOf("a"), 1))
    }

    @Test
    fun allDuplicates() {
        assertEquals("", solution.kthDistinct(listOf("a", "a", "b", "b"), 1))
    }
}
