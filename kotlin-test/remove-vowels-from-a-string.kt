package removevowelsfromastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveVowelsFromAStringTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(
            "ltcdscmmntyfrcdrs",
            solution.removeVowels("leetcodeisacommunityforcoders")
        )
    }

    @Test
    fun allVowelsBecomeEmpty() {
        assertEquals("", solution.removeVowels("aeiou"))
    }

    @Test
    fun consonantsRemainUnchanged() {
        assertEquals("rhythm", solution.removeVowels("rhythm"))
    }

    @Test
    fun uppercaseVowelsArePreserved() {
        assertEquals("AEIOUbc", solution.removeVowels("AEIOUabc"))
    }
}
