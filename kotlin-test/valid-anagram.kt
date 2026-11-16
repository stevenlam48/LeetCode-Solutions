package validanagram

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidAnagramTest {
    @Test
    fun leetCodeAnagramExample() {
        assertTrue(Solution().isAnagram("anagram", "nagaram"))
    }

    @Test
    fun leetCodeNonAnagramExample() {
        assertFalse(Solution().isAnagram("rat", "car"))
    }

    @Test
    fun differentLengths() {
        assertFalse(Solution().isAnagram("a", "ab"))
    }

    @Test
    fun bothEmpty() {
        assertTrue(Solution().isAnagram("", ""))
    }
}
