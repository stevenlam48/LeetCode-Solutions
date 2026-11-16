package countbeautifulsubstringsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBeautifulSubstringsITest {
    @Test
    fun examples() {
        assertEquals(2, Solution().beautifulSubstrings("baeyh", 2))
        assertEquals(3, Solution().beautifulSubstrings("abba", 1))
    }

    @Test
    fun productCondition() {
        assertEquals(1, Solution().beautifulSubstrings("abba", 2))
    }

    @Test
    fun noBeautifulSubstrings() {
        assertEquals(0, Solution().beautifulSubstrings("bcdf", 1))
        assertEquals(0, Solution().beautifulSubstrings("", 1))
    }
}
