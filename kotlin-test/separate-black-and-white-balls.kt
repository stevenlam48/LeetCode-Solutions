package separateblackandwhiteballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeparateBlackAndWhiteBallsTest {
    @Test
    fun exampleOneZeroOne() {
        assertEquals(1L, Solution().minimumSteps("101"))
    }

    @Test
    fun exampleOneZeroZero() {
        assertEquals(2L, Solution().minimumSteps("100"))
    }

    @Test
    fun alreadySeparated() {
        assertEquals(0L, Solution().minimumSteps("0111"))
    }

    @Test
    fun singleBall() {
        assertEquals(0L, Solution().minimumSteps("0"))
        assertEquals(0L, Solution().minimumSteps("1"))
    }

    @Test
    fun twoZerosAfterTwoOnes() {
        assertEquals(4L, Solution().minimumSteps("1100"))
    }

    @Test
    fun oneSwap() {
        assertEquals(1L, Solution().minimumSteps("10"))
    }
}
