package frequencyofthemostfrequentelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FrequencyOfTheMostFrequentElementTest {
    @Test
    fun `all three elements can become four`() {
        assertEquals(3, Solution().maxFrequency(intArrayOf(1, 2, 4), 5))
    }

    @Test
    fun `only two elements can be made equal`() {
        assertEquals(2, Solution().maxFrequency(intArrayOf(1, 4, 8, 13), 5))
    }

    @Test
    fun `insufficient operations preserve the existing pair`() {
        assertEquals(2, Solution().maxFrequency(intArrayOf(3, 9, 9), 2))
    }

    @Test
    fun `already equal elements need no operations`() {
        assertEquals(4, Solution().maxFrequency(intArrayOf(5, 5, 5, 5), 0))
    }

    @Test
    fun `window calculation uses long arithmetic`() {
        val nums = intArrayOf(Int.MAX_VALUE - 2, Int.MAX_VALUE)

        assertEquals(1, Solution().maxFrequency(nums, 1))
    }
}
