package replacealldigitswithcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceAllDigitsWithCharactersTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals("abcdef", solution.replaceDigits("a1c1e1"))
    }

    @Test
    fun secondExample() {
        assertEquals("abbdcfdhe", solution.replaceDigits("a1b2c3d4e"))
    }

    @Test
    fun zeroShiftKeepsThePreviousCharacter() {
        assertEquals("aabb", solution.replaceDigits("a0b0"))
    }

    @Test
    fun singleCharacterIsUnchanged() {
        assertEquals("a", solution.replaceDigits("a"))
    }
}
