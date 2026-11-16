package putboxesintothewarehousei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PutBoxesIntoTheWarehouseITest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.maxBoxesInWarehouse(
            intArrayOf(4, 3, 4, 1, 5), intArrayOf(5, 3, 3, 4, 1)
        )
        assertEquals(3, actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.maxBoxesInWarehouse(
            intArrayOf(1, 2, 2, 3, 4), intArrayOf(3, 4, 1, 2)
        )
        assertEquals(3, actual)
    }

    @Test
    fun validCase3_noBoxFits() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(4, 5), intArrayOf(3, 2))
        assertEquals(0, actual)
    }

    @Test
    fun validCase4_warehouseFills() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(1, 1), intArrayOf(2))
        assertEquals(1, actual)
    }

    @Test
    fun validCase5_allBoxesFit() {
        val actual = solution.maxBoxesInWarehouse(intArrayOf(1, 2, 3), intArrayOf(3, 3, 3))
        assertEquals(3, actual)
    }

    @Test
    fun validCase6_noBoxes() {
        val actual = solution.maxBoxesInWarehouse(IntArray(0), intArrayOf(1))
        assertEquals(0, actual)
    }
}
