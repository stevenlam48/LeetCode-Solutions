package minimumrecolorstogetkconsecutiveblackblocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimumRecolors("WBBWWBBWBW", 7))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().minimumRecolors("WBWBBBW", 2))
    }

    @Test
    fun singleBlock() {
        assertEquals(0, Solution().minimumRecolors("B", 1))
        assertEquals(1, Solution().minimumRecolors("W", 1))
    }

    @Test
    fun wholeStringWhite() {
        assertEquals(3, Solution().minimumRecolors("WWW", 3))
    }

    @Test
    fun windowOfOne() {
        assertEquals(0, Solution().minimumRecolors("WBBW", 1))
    }
}
