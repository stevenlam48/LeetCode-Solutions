package findfirstpalindromicstringinthearray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindFirstPalindromicStringInTheArrayTest {
    @Test
    fun standardExample() {
        assertEquals("ada", Solution().firstPalindrome(arrayOf("abc", "car", "ada", "racecar", "cool")))
    }

    @Test
    fun secondExample() {
        assertEquals("racecar", Solution().firstPalindrome(arrayOf("notapalindrome", "racecar")))
    }

    @Test
    fun noPalindrome() {
        assertEquals("", Solution().firstPalindrome(arrayOf("def", "ghi")))
    }

    @Test
    fun singleCharacter() {
        assertEquals("a", Solution().firstPalindrome(arrayOf("a")))
    }

    @Test
    fun evenLengthPalindrome() {
        assertEquals("abba", Solution().firstPalindrome(arrayOf("ab", "abba", "aba")))
    }
}
