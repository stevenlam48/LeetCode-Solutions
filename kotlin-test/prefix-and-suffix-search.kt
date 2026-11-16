package prefixandsuffixsearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrefixAndSuffixSearchTest {
    @Test
    fun singleWord() {
        val filter = WordFilter(listOf("apple"))
        assertEquals(0, filter.f("a", "e"))
        assertEquals(-1, filter.f("b", ""))
    }

    @Test
    fun multipleWords() {
        val filter = WordFilter(listOf("apple", "app"))
        assertEquals(0, filter.f("a", "e"))
        assertEquals(1, filter.f("ap", "p"))
        assertEquals(1, filter.f("app", ""))
        assertEquals(0, filter.f("appl", "e"))
        assertEquals(1, filter.f("", ""))
    }

    @Test
    fun noMatch() {
        val filter = WordFilter(listOf("apple", "app"))
        assertEquals(-1, filter.f("x", "y"))
        assertEquals(-1, filter.f("app", "x"))
    }

    @Test
    fun duplicateWords() {
        val filter = WordFilter(listOf("ab", "ab"))
        assertEquals(1, filter.f("a", "b"))
    }
}
