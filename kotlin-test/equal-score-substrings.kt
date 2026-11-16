package equalscoresubstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualScoreSubstringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.scoreBalance("adcb"))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.scoreBalance("abc"))
    }

    @Test
    fun testNoBalance() {
        assertFalse(solution.scoreBalance("ab"))
        assertFalse(solution.scoreBalance("abcd"))
    }

    @Test
    fun testSingleCharacter() {
        assertFalse(solution.scoreBalance("a"))
        assertFalse(solution.scoreBalance("z"))
    }

    @Test
    fun testOddTotal() {
        assertFalse(solution.scoreBalance("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun testEmpty() {
        assertFalse(solution.scoreBalance(""))
    }
}
