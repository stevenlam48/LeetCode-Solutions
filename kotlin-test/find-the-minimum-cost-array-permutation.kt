package findtheminimumcostarraypermutation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheMinimumCostArrayPermutationTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().findPermutation(intArrayOf(1, 0, 2)))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(0, 2, 1), Solution().findPermutation(intArrayOf(0, 2, 1)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0), Solution().findPermutation(intArrayOf(0)))
    }

    @Test
    fun twoElements() {
        assertArrayEquals(intArrayOf(0, 1), Solution().findPermutation(intArrayOf(1, 0)))
    }
}
