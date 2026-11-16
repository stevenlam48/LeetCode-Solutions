package burstballoons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BurstBalloonsTest {
    @Test
    fun leetCodeExample() {
        assertEquals(167, Solution().maxCoins(intArrayOf(3, 1, 5, 8)))
    }

    @Test
    fun twoBalloons() {
        assertEquals(10, Solution().maxCoins(intArrayOf(1, 5)))
    }

    @Test
    fun noBalloons() {
        assertEquals(0, Solution().maxCoins(intArrayOf()))
    }

    @Test
    fun nonpositiveBalloonsAreIgnored() {
        assertEquals(167, Solution().maxCoins(intArrayOf(0, 3, 0, 1, 5, 0, 8)))
    }
}
