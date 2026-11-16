package couplesholdinghands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CouplesHoldingHandsTest {
    @Test
    fun `already seated couples need no swaps`() {
        assertEquals(0, Solution().minSwapsCouples(intArrayOf(1, 0, 3, 2)))
    }

    @Test
    fun `one swap joins two couples`() {
        assertEquals(1, Solution().minSwapsCouples(intArrayOf(0, 2, 1, 3)))
    }

    @Test
    fun `a cycle of three couches needs two swaps`() {
        assertEquals(2, Solution().minSwapsCouples(intArrayOf(0, 2, 1, 4, 3, 5)))
    }

    @Test
    fun `handles a single couple`() {
        assertEquals(0, Solution().minSwapsCouples(intArrayOf(1, 0)))
    }
}
