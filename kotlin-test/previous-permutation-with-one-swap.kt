package previouspermutationwithoneswap

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PreviousPermutationWithOneSwapTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(3, 1, 2), Solution().prevPermOpt1(intArrayOf(3, 2, 1)))
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(1, 1, 5), Solution().prevPermOpt1(intArrayOf(1, 1, 5)))
    }

    @Test
    fun exampleThree() {
        assertArrayEquals(intArrayOf(1, 7, 4, 6, 9), Solution().prevPermOpt1(intArrayOf(1, 9, 4, 6, 7)))
    }

    @Test
    fun duplicates() {
        assertArrayEquals(intArrayOf(1, 3, 1, 3), Solution().prevPermOpt1(intArrayOf(3, 1, 1, 3)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(1), Solution().prevPermOpt1(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertArrayEquals(intArrayOf(1, 2), Solution().prevPermOpt1(intArrayOf(2, 1)))
    }
}
