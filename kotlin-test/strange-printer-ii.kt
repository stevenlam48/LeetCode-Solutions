package strangeprinterii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StrangePrinterIiTest {
    @Test
    fun `nested rectangles are printable`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 2, 2, 1),
            intArrayOf(1, 2, 2, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertTrue(Solution().isPrintable(grid))
    }

    @Test
    fun `overlapping rectangles can form a cycle`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 3, 3),
            intArrayOf(1, 3, 3, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertFalse(Solution().isPrintable(grid))
    }

    @Test
    fun `alternating colors form a cycle`() {
        val grid = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 1, 2),
            intArrayOf(1, 2, 1)
        )
        assertFalse(Solution().isPrintable(grid))
    }

    @Test
    fun `separate rectangles are printable`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(3, 3, 3)
        )
        assertTrue(Solution().isPrintable(grid))
    }
}
