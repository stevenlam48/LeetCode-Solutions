package maximumfonttofitasentenceinascreen

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFontToFitASentenceInAScreenTest {
    @Test
    fun example1() {
        assertEquals(
            6,
            Solution().maxFont(
                "helloworld", 79, 20,
                intArrayOf(6, 8, 10, 12, 14, 16, 18, 24, 36),
                FakeFontInfo()
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            4,
            Solution().maxFont("leetcode", 1000, 50, intArrayOf(1, 2, 4), FakeFontInfo())
        )
    }

    @Test
    fun example3() {
        assertEquals(
            -1,
            Solution().maxFont("easyquestion", 100, 100, intArrayOf(10, 15, 20, 25), FakeFontInfo())
        )
    }

    @Test
    fun widthLimit() {
        assertEquals(2, Solution().maxFont("a", 2, 10, intArrayOf(1, 2, 3), FakeFontInfo()))
    }

    @Test
    fun heightLimit() {
        assertEquals(2, Solution().maxFont("a", 100, 2, intArrayOf(1, 2, 3), FakeFontInfo()))
    }

    @Test
    fun singleFontFits() {
        assertEquals(5, Solution().maxFont("abc", 100, 100, intArrayOf(5), FakeFontInfo()))
    }
}

private class FakeFontInfo : FontInfo {
    override fun getWidth(fontSize: Int, ch: Char): Int = fontSize

    override fun getHeight(fontSize: Int): Int = fontSize
}
