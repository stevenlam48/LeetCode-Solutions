package makearraynondecreasing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MakeArrayNonDecreasingTest {
    @Test
    fun `finds longest achievable non-decreasing subsequence size`() {
        assertEquals(3, Solution().maximumPossibleSize(intArrayOf(4, 2, 5, 3, 5)))
    }

    @Test
    fun `keeps every element of sorted array`() {
        assertEquals(3, Solution().maximumPossibleSize(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `keeps duplicate elements`() {
        assertEquals(4, Solution().maximumPossibleSize(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun `handles empty array`() {
        assertEquals(0, Solution().maximumPossibleSize(intArrayOf()))
    }
}
