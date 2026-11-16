package countvowelsubstringsofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountVowelSubstringsOfAStringTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().countVowelSubstrings("aeiouu"))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().countVowelSubstrings("unicornarihan"))
    }

    @Test
    fun example3() {
        assertEquals(7, Solution().countVowelSubstrings("cuaieuouac"))
    }

    @Test
    fun exactlyAllVowels() {
        assertEquals(1, Solution().countVowelSubstrings("aeiou"))
    }

    @Test
    fun onlyConsonants() {
        assertEquals(0, Solution().countVowelSubstrings("aaa"))
    }
}
