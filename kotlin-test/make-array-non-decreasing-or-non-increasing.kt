package makearraynondecreasingornonincreasing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MakeArrayNonDecreasingOrNonIncreasingTest {
    @Test
    fun `chooses cheaper conversion direction`() {
        assertEquals(4, Solution().convertArray(intArrayOf(3, 2, 4, 5, 0)))
    }

    @Test
    fun `handles already non-decreasing array`() {
        assertEquals(0, Solution().convertArray(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `handles non-increasing array with duplicates`() {
        assertEquals(0, Solution().convertArray(intArrayOf(4, 4, 2, 2, 1)))
    }

    @Test
    fun `handles single element`() {
        assertEquals(0, Solution().convertArray(intArrayOf(7)))
    }

    @Test
    fun `handles empty array`() {
        assertEquals(0, Solution().convertArray(intArrayOf()))
    }
}
