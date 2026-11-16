package tallestbillboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TallestBillboardTest {
    @Test
    fun standardExamples() {
        assertEquals(6, Solution().tallestBillboard(intArrayOf(1, 2, 3, 6)))
        assertEquals(10, Solution().tallestBillboard(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun noNonzeroBillboard() {
        assertEquals(0, Solution().tallestBillboard(intArrayOf(1, 2)))
        assertEquals(0, Solution().tallestBillboard(intArrayOf()))
    }

    @Test
    fun duplicateRods() {
        assertEquals(12, Solution().tallestBillboard(intArrayOf(6, 6, 6, 6)))
    }
}
