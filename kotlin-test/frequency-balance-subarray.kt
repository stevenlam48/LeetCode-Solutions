package frequencybalancesubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FrequencyBalanceSubarrayTest {
    @Test
    fun `one value occurs twice and the other once`() {
        assertEquals(3, Solution().getLength(intArrayOf(1, 2, 2)))
    }

    @Test
    fun `single distinct value makes whole array balanced`() {
        assertEquals(4, Solution().getLength(intArrayOf(4, 4, 4, 4)))
    }

    @Test
    fun `longest balanced subarray can start after prefix`() {
        val nums = intArrayOf(0, -1, -1, 2, 2, 2, 2)

        assertEquals(6, Solution().getLength(nums))
    }

    @Test
    fun `equal frequencies across distinct values do not satisfy two-frequency condition`() {
        assertEquals(3, Solution().getLength(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun `empty and single element arrays`() {
        assertEquals(0, Solution().getLength(intArrayOf()))
        assertEquals(1, Solution().getLength(intArrayOf(7)))
    }
}
