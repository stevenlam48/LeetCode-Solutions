package globalandlocalinversions

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GlobalAndLocalInversionsTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertTrue(solution.isIdealPermutation(intArrayOf(1, 0, 2)))
        assertFalse(solution.isIdealPermutation(intArrayOf(1, 2, 0)))
    }

    @Test
    fun `single element and multiple adjacent swaps`() {
        val solution = Solution()
        assertTrue(solution.isIdealPermutation(intArrayOf(0)))
        assertTrue(solution.isIdealPermutation(intArrayOf(0, 2, 1, 4, 3)))
    }

    @Test
    fun `nonlocal inversion`() {
        assertFalse(Solution().isIdealPermutation(intArrayOf(2, 0, 1)))
    }
}
