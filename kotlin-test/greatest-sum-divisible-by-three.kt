package greatestsumdivisiblebythree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestSumDivisibleByThreeTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals(18, solution.maxSumDivThree(intArrayOf(3, 6, 5, 1, 8)))
        assertEquals(0, solution.maxSumDivThree(intArrayOf(4)))
        assertEquals(12, solution.maxSumDivThree(intArrayOf(1, 2, 3, 4, 4)))
    }

    @Test
    fun `empty selection and repeated residues`() {
        val solution = Solution()
        assertEquals(0, solution.maxSumDivThree(intArrayOf()))
        assertEquals(0, solution.maxSumDivThree(intArrayOf(2, 2)))
        assertEquals(6, solution.maxSumDivThree(intArrayOf(3, 3)))
    }

    @Test
    fun `single divisible value`() {
        assertEquals(9, Solution().maxSumDivThree(intArrayOf(9)))
    }
}
