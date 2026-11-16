package zumagame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZumaGameTest {
    @Test
    fun example1() {
        assertEquals(-1, Solution().findMinStep("WRRBBW", "RB"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().findMinStep("WWRRBBWW", "WRBRW"))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().findMinStep("G", "GGGGG"))
    }

    @Test
    fun example4() {
        assertEquals(3, Solution().findMinStep("RBYYBBRRB", "YRBGB"))
    }

    @Test
    fun emptyBoard() {
        assertEquals(0, Solution().findMinStep("", "ABC"))
    }

    @Test
    fun noHand() {
        assertEquals(-1, Solution().findMinStep("RR", ""))
    }
}
