package splitthearraytomakecoprimeproducts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitTheArrayToMakeCoprimeProductsTest {
    private val solution = Solution()

    @Test
    fun `finds the earliest split after shared factors end`() {
        assertEquals(2, solution.findValidSplit(intArrayOf(6, 35, 22, 13)))
    }

    @Test
    fun `returns the first index when it is already valid`() {
        assertEquals(0, solution.findValidSplit(intArrayOf(2, 3, 5, 7, 11)))
    }

    @Test
    fun `returns minus one when every split shares a prime factor`() {
        assertEquals(-1, solution.findValidSplit(intArrayOf(6, 10, 15)))
    }

    @Test
    fun `waits until all shared primes have moved to the left`() {
        assertEquals(3, solution.findValidSplit(intArrayOf(6, 35, 14, 5, 11)))
    }

    @Test
    fun `returns minus one for a single element`() {
        assertEquals(-1, solution.findValidSplit(intArrayOf(2)))
    }
}
