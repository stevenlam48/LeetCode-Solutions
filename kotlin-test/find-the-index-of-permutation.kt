package findtheindexofpermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheIndexOfPermutationTest {
    @Test
    fun identity() {
        assertEquals(0, Solution().getPermutationIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun reverse() {
        assertEquals(5, Solution().getPermutationIndex(intArrayOf(3, 2, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().getPermutationIndex(intArrayOf(1)))
    }

    @Test
    fun swapFirstTwo() {
        assertEquals(2, Solution().getPermutationIndex(intArrayOf(2, 1, 3)))
    }

    @Test
    fun rotation() {
        assertEquals(4, Solution().getPermutationIndex(intArrayOf(3, 1, 2)))
    }

    @Test
    fun middlePermutation() {
        assertEquals(3, Solution().getPermutationIndex(intArrayOf(2, 3, 1)))
    }
}
