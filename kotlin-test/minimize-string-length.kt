package minimizestringlength

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeStringLengthTest {
    private val solution = Solution()

    @Test
    fun removesDuplicateCharacters() {
        assertEquals(3, solution.minimizedStringLength("aaabc"))
    }

    @Test
    fun keepsOnlyCharactersPresentAtLeastOnce() {
        assertEquals(3, solution.minimizedStringLength("cbbd"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertEquals(1, solution.minimizedStringLength("z"))
    }

    @Test
    fun handlesEmptyString() {
        assertEquals(0, solution.minimizedStringLength(""))
    }
}
