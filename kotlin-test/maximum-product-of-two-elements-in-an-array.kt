package maximumproductoftwoelementsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoElementsInAnArrayTest {
    @Test
    fun example1() {
        assertEquals(12, Solution().maxProduct(intArrayOf(3, 4, 5, 2)))
    }

    @Test
    fun example2() {
        assertEquals(16, Solution().maxProduct(intArrayOf(1, 5, 4, 5)))
    }

    @Test
    fun twoElements() {
        assertEquals(12, Solution().maxProduct(intArrayOf(3, 7)))
    }

    @Test
    fun allOnes() {
        assertEquals(0, Solution().maxProduct(intArrayOf(1, 1)))
    }

    @Test
    fun duplicates() {
        assertEquals(81, Solution().maxProduct(intArrayOf(10, 10, 1)))
    }
}
