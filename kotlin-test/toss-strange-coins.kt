package tossstrangecoins

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TossStrangeCoinsTest {
    @Test
    fun singleCoinHeads() {
        assertEquals(0.4, Solution().probabilityOfHeads(doubleArrayOf(0.4), 1), 1e-9)
    }

    @Test
    fun singleCoinNoHeads() {
        assertEquals(0.6, Solution().probabilityOfHeads(doubleArrayOf(0.4), 0), 1e-9)
    }

    @Test
    fun fourFairCoinsExactlyTwo() {
        assertEquals(0.375, Solution().probabilityOfHeads(doubleArrayOf(0.5, 0.5, 0.5, 0.5), 2), 1e-9)
    }

    @Test
    fun threeCoinsExactlyOne() {
        assertEquals(0.432, Solution().probabilityOfHeads(doubleArrayOf(0.4, 0.4, 0.4), 1), 1e-9)
    }

    @Test
    fun targetZeroMultipliesTails() {
        assertEquals(0.25, Solution().probabilityOfHeads(doubleArrayOf(0.5, 0.5), 0), 1e-9)
    }
}
