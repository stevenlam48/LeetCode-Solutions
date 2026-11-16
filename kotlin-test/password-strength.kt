package passwordstrength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PasswordStrengthTest {
    private val solution = Solution()

    @Test
    fun addsWeightForEachUniqueCharacter() {
        assertEquals(23, solution.passwordStrength("abcABC123!"))
    }

    @Test
    fun countsRepeatedCharactersOnlyOnce() {
        assertEquals(11, solution.passwordStrength("aaaA11!"))
    }

    @Test
    fun handlesEmptyPassword() {
        assertEquals(0, solution.passwordStrength(""))
    }

    @Test
    fun countsUniqueSymbols() {
        assertEquals(10, solution.passwordStrength("!@!"))
    }
}
