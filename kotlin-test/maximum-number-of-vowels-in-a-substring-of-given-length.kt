package maximumnumberofvowelsinasubstringofgivenlength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofvowelsinasubstringofgivenlengthTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxVowels("abciiidef", 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxVowels("aeiou", 2))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().maxVowels("leetcode", 3))
    }

    @Test
    fun noVowels() {
        assertEquals(0, Solution().maxVowels("rhythms", 4))
    }

    @Test
    fun singleVowel() {
        assertEquals(1, Solution().maxVowels("a", 1))
    }
}
