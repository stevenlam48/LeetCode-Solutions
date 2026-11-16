package decodexoredpermutation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DecodeXoredPermutationTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2, 3), Solution().decode(intArrayOf(3, 1)))
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(2, 4, 1, 5, 3),
            Solution().decode(intArrayOf(6, 5, 4, 6))
        )
    }

    @Test
    fun smallestPermutation() {
        assertArrayEquals(intArrayOf(2, 3, 1), Solution().decode(intArrayOf(1, 2)))
    }

    @Test
    fun fiveElements() {
        assertArrayEquals(
            intArrayOf(1, 5, 2, 4, 3),
            Solution().decode(intArrayOf(4, 7, 6, 7))
        )
    }
}
