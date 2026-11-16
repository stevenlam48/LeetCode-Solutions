package vowelsgameinastring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VowelsGameInAStringTest {
    private val solution = Solution()

    @Test
    fun aliceWinsWhenVowelExists() {
        assertTrue(solution.doesAliceWin("leetcoder"))
        assertTrue(solution.doesAliceWin("bbcdae"))
    }

    @Test
    fun aliceLosesWithoutVowels() {
        assertFalse(solution.doesAliceWin("bbcd"))
        assertFalse(solution.doesAliceWin("AEIOU"))
    }

    @Test
    fun handlesEmptyString() {
        assertFalse(solution.doesAliceWin(""))
    }
}
