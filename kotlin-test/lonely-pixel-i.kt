package lonelypixeli

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LonelyPixelITest {
    private fun picture(vararg rows: String): Array<CharArray> = rows.map { it.toCharArray() }.toTypedArray()

    @Test
    fun twoLonelyPixels() {
        assertEquals(2, Solution().findLonelyPixel(picture("WWB", "WWW", "BWW")))
    }

    @Test
    fun noLonelyPixels() {
        assertEquals(0, Solution().findLonelyPixel(picture("BBB", "BBW", "BBB")))
    }

    @Test
    fun singlePixel() {
        assertEquals(1, Solution().findLonelyPixel(picture("B")))
    }

    @Test
    fun singleWhitePixel() {
        assertEquals(0, Solution().findLonelyPixel(picture("W")))
    }

    @Test
    fun sharedRowOrColumn() {
        assertEquals(0, Solution().findLonelyPixel(picture("BB", "WB")))
    }
}
