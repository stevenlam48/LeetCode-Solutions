package permutationsiv

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PermutationsIvTest {
    @Test
    fun firstPermutation() {
        assertArrayEquals(intArrayOf(1, 2, 3), Solution().permute(3, 1))
    }

    @Test
    fun middlePermutation() {
        assertArrayEquals(intArrayOf(3, 2, 1), Solution().permute(3, 2))
    }

    @Test
    fun evenLengthPermutation() {
        assertArrayEquals(intArrayOf(2, 3, 4, 1), Solution().permute(4, 4))
    }

    @Test
    fun rankBeyondPermutationCount() {
        assertArrayEquals(IntArray(0), Solution().permute(3, 4))
    }

    @Test
    fun singleNumber() {
        assertArrayEquals(intArrayOf(1), Solution().permute(1, 1))
    }
}
