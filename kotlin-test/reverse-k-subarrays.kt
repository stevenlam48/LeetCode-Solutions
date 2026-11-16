package reverseksubarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseKSubarraysTest {
    @Test
    fun twoSubarrays() {
        assertArrayEquals(
            intArrayOf(3, 2, 1, 6, 5, 4),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5, 6), 2)
        )
    }

    @Test
    fun threeSubarrays() {
        assertArrayEquals(
            intArrayOf(2, 1, 4, 3, 6, 5),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5, 6), 3)
        )
    }

    @Test
    fun oneSubarray() {
        assertArrayEquals(
            intArrayOf(6, 5, 4, 3, 2, 1),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5, 6), 1)
        )
    }

    @Test
    fun kEqualsLength() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5, 6),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5, 6), 6)
        )
    }

    @Test
    fun fourSubarrays() {
        assertArrayEquals(
            intArrayOf(3, 2, 1, 6, 5, 4, 9, 8, 7, 12, 11, 10),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 4)
        )
    }

    @Test
    fun remainderLeftInPlace() {
        assertArrayEquals(
            intArrayOf(2, 1, 4, 3, 5),
            Solution().reverseSubarrays(intArrayOf(1, 2, 3, 4, 5), 2)
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().reverseSubarrays(intArrayOf(1), 1)
        )
    }
}
