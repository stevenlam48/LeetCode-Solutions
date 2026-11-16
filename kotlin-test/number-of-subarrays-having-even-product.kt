package numberofsubarrayshavingevenproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysHavingEvenProductTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(8L, solution.evenProduct(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allOdd() {
        assertEquals(0L, solution.evenProduct(intArrayOf(1, 3, 5)))
    }

    @Test
    fun allEven() {
        assertEquals(3L, solution.evenProduct(intArrayOf(2, 4)))
    }

    @Test
    fun empty() {
        assertEquals(0L, solution.evenProduct(intArrayOf()))
    }
}
