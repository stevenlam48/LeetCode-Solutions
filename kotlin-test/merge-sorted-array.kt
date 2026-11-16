package mergesortedarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSortedArrayTest {
    @Test
    fun exampleOne() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        Solution().merge(nums1, 3, intArrayOf(2, 5, 6), 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }

    @Test
    fun exampleTwo() {
        val nums1 = intArrayOf(1)
        Solution().merge(nums1, 1, intArrayOf(), 0)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun firstArrayHasNoElements() {
        val nums1 = intArrayOf(0)
        Solution().merge(nums1, 0, intArrayOf(1), 1)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun negativesAndDuplicates() {
        val nums1 = intArrayOf(-5, -1, -1, 3, 0, 0, 0, 0)
        Solution().merge(nums1, 4, intArrayOf(-4, -1, 0, 8), 4)
        assertArrayEquals(intArrayOf(-5, -4, -1, -1, -1, 0, 3, 8), nums1)
    }
}
