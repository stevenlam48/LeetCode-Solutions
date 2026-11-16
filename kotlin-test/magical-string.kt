package magicalstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MagicalStringTest {
    private val solution = Solution()

    @Test
    fun returnsZeroForEmptyPrefix() {
        assertEquals(0, solution.magicalString(0))
    }

    @Test
    fun handlesSingleCharacterPrefix() {
        assertEquals(1, solution.magicalString(1))
    }

    @Test
    fun countsOnesInFirstSixCharacters() {
        assertEquals(3, solution.magicalString(6))
    }

    @Test
    fun extendsStringFromEarlierGeneratedCharacters() {
        assertEquals(4, solution.magicalString(9))
        assertEquals(5, solution.magicalString(12))
    }
}
