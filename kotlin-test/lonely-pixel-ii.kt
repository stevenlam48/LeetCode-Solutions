package lonelypixelii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LonelyPixelIiTest {
    private fun picture(vararg rows: String): Array<CharArray> = rows.map { it.toCharArray() }.toTypedArray()

    @Test
    fun singleBlackPixel() {
        assertEquals(1, Solution().findBlackPixel(picture("B"), 1))
    }

    @Test
    fun allRowsEqual() {
        assertEquals(4, Solution().findBlackPixel(picture("BB", "BB"), 2))
    }

    @Test
    fun rowStringDoesNotRepeatEnough() {
        assertEquals(0, Solution().findBlackPixel(picture("BB"), 2))
    }

    @Test
    fun repeatedRowsWithTwoColumns() {
        assertEquals(4, Solution().findBlackPixel(picture("WBBW", "WBBW"), 2))
    }

    @Test
    fun differentRowPatterns() {
        assertEquals(0, Solution().findBlackPixel(picture("WBW", "BBW"), 2))
    }
}
