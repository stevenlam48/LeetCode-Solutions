package findpermutation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindPermutationTest {
    private val solution = Solution()

    @Test
    fun exampleIncreasing() {
        assertArrayEquals(intArrayOf(1, 2), solution.findPermutation("I"))
    }

    @Test
    fun exampleDecreaseThenIncrease() {
        assertArrayEquals(intArrayOf(2, 1, 3), solution.findPermutation("DI"))
    }

    @Test
    fun trailingDecrease() {
        assertArrayEquals(intArrayOf(2, 1, 4, 3), solution.findPermutation("DID"))
    }

    @Test
    fun multipleRuns() {
        assertArrayEquals(intArrayOf(3, 2, 1, 4, 7, 6, 5), solution.findPermutation("DDIIDD"))
    }
}
