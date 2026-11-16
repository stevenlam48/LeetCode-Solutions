package countnumberoftexts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfTextsTest {
    private val solution = Solution()

    @Test
    fun mixedKeyGroups() {
        assertEquals(8, solution.countTexts("22233"))
    }

    @Test
    fun emptyAndSingleKey() {
        assertEquals(1, solution.countTexts(""))
        assertEquals(1, solution.countTexts("9"))
    }

    @Test
    fun fourPressesOnFourLetterKey() {
        assertEquals(8, solution.countTexts("7777"))
    }

    @Test
    fun fourPressesOnThreeLetterKey() {
        assertEquals(7, solution.countTexts("2222"))
    }

    @Test
    fun longInputUsesModulo() {
        assertEquals(82876089, solution.countTexts("2".repeat(36)))
    }
}
