package sumofgoodsubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfGoodSubsequencesTest {
    @Test
    fun exampleOne() {
        assertEquals(14, Solution().sumOfGoodSubsequences(intArrayOf(1, 2, 1)))
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(40, Solution().sumOfGoodSubsequences(intArrayOf(3, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().sumOfGoodSubsequences(intArrayOf(1)))
    }
}
