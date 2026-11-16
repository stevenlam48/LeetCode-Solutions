package putboxesintothewarehouseii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PutBoxesIntoTheWarehouseIITest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.maxBoxesInWarehouse(
            intArrayOf(3, 5, 5, 2), intArrayOf(2, 1, 3, 4, 5)
        )
        assertEquals(3, actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.maxBoxesInWarehouse(
            intArrayOf(1, 2, 2, 3, 4), intArrayOf(3, 4, 1, 2)
        )
        assertEquals(4, actual)
    }

    @Test
    fun validCase3_bothEnds() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(5, 1, 2), intArrayOf(1, 5))
        assertEquals(2, actual)
    }

    @Test
    fun validCase4_noBoxFits() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(4), intArrayOf(3))
        assertEquals(0, actual)
    }

    @Test
    fun validCase5_fillFromLeft() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        assertEquals(3, actual)
    }

    @Test
    fun validCase6_singleRoom() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(2), intArrayOf(2))
        assertEquals(1, actual)
    }
}
