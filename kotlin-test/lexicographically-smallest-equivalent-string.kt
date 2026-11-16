package lexicographicallysmallestequivalentstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestEquivalentStringTest {
    @Test
    fun example1() {
        assertEquals("makkek", Solution().smallestEquivalentString("parker", "morris", "parser"))
    }

    @Test
    fun example2() {
        assertEquals("hdld", Solution().smallestEquivalentString("hello", "world", "hold"))
    }

    @Test
    fun example3() {
        assertEquals(
            "aauaaaaada",
            Solution().smallestEquivalentString("leetcode", "programs", "sourcecode")
        )
    }

    @Test
    fun singleEquivalence() {
        assertEquals("aa", Solution().smallestEquivalentString("a", "b", "ab"))
    }
}
