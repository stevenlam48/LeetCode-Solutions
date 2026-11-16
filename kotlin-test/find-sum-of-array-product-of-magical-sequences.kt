package findsumofarrayproductofmagicalsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSumOfArrayProductOfMagicalSequencesTest {
    @Test
    fun testExample1() {
        assertEquals(
            991600007,
            Solution().magicalSum(5, 5, intArrayOf(1, 10, 100, 10000, 1000000))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(170, Solution().magicalSum(2, 2, intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(28, Solution().magicalSum(1, 1, intArrayOf(28)))
    }

    @Test
    fun testSingleElementMultiplePicks() {
        // Only one number, so every sequence is [2, 2]; product 4, popcount(4) = 1.
        assertEquals(4, Solution().magicalSum(2, 1, intArrayOf(2)))
    }
}
