package checkifthesentenceispangram

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfTheSentenceIsPangramTest {
    private val solution = Solution()

    @Test
    fun testPangram() {
        assertTrue(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
    }

    @Test
    fun testNotPangram() {
        assertFalse(solution.checkIfPangram("leetcode"))
    }

    @Test
    fun testSingleCharacter() {
        assertFalse(solution.checkIfPangram("a"))
    }

    @Test
    fun testRepeatedLetters() {
        assertFalse(solution.checkIfPangram("aaaaaaaaaaaaaaaaaaaaaaaaaaa"))
    }
}
