package checkifanoriginalstringexistsgiventwoencodedstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAnOriginalStringExistsGivenTwoEncodedStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.possiblyEquals("internationalization", "i18n"))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.possiblyEquals("l123e", "44"))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.possiblyEquals("a5b", "c5b"))
    }

    @Test
    fun testExample4() {
        assertTrue(solution.possiblyEquals("112s", "g841"))
    }

    @Test
    fun testExample5() {
        assertFalse(solution.possiblyEquals("ab", "a2"))
    }

    @Test
    fun testSingleDigit() {
        assertTrue(solution.possiblyEquals("2", "ab"))
        assertTrue(solution.possiblyEquals("a1", "ab"))
    }

    @Test
    fun testDigitMismatch() {
        assertFalse(solution.possiblyEquals("1", "12"))
        assertTrue(solution.possiblyEquals("1", "1"))
    }
}
