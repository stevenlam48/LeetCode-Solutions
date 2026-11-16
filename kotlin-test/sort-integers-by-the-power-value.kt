package sortintegersbythepowervalue

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortIntegersByThePowerValueTest {
    @Test
    fun standardExamples() {
        assertEquals(13, Solution().getKth(12, 15, 2))
        assertEquals(7, Solution().getKth(7, 11, 4))
    }

    @Test
    fun singleValue() {
        assertEquals(1, Solution().getKth(1, 1, 1))
    }

    @Test
    fun powerTiesUseIntegerValue() {
        assertEquals(8, Solution().getKth(8, 10, 1))
        assertEquals(10, Solution().getKth(8, 10, 2))
        assertEquals(9, Solution().getKth(8, 10, 3))
    }

    @Test
    fun firstAndLastPositions() {
        val solution = Solution()
        assertEquals(1, solution.getKth(1, 5, 1))
        assertEquals(3, solution.getKth(1, 5, 5))
    }
}
