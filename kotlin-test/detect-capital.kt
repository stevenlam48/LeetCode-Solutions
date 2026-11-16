package detectcapital

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetectCapitalTest {
    private val solution = Solution()

    @Test
    fun allUppercaseIsValid() {
        assertTrue(solution.detectCapitalUse("USA"))
    }

    @Test
    fun allLowercaseIsValid() {
        assertTrue(solution.detectCapitalUse("leetcode"))
    }

    @Test
    fun onlyFirstUppercaseIsValid() {
        assertTrue(solution.detectCapitalUse("Google"))
    }

    @Test
    fun misplacedUppercaseIsInvalid() {
        assertFalse(solution.detectCapitalUse("FlaG"))
        assertFalse(solution.detectCapitalUse("mL"))
    }
}
