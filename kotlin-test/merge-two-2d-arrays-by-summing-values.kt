package mergetwo2darraysbysummingvalues

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeTwo2dArraysBySummingValuesTest {
    private fun assertResult(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertArrayEquals(expected, actual)
    }

    @Test
    fun example1() {
        val nums1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5))
        val nums2 = arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
        val expected = arrayOf(intArrayOf(1, 6), intArrayOf(2, 3), intArrayOf(3, 2), intArrayOf(4, 6))
        assertResult(expected, Solution().mergeArrays(nums1, nums2))
    }

    @Test
    fun example2() {
        val nums1 = arrayOf(intArrayOf(2, 4), intArrayOf(3, 6), intArrayOf(5, 5))
        val nums2 = arrayOf(intArrayOf(1, 3), intArrayOf(4, 3))
        val expected = arrayOf(
            intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(5, 5)
        )
        assertResult(expected, Solution().mergeArrays(nums1, nums2))
    }

    @Test
    fun firstEmpty() {
        val expected = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertResult(expected, Solution().mergeArrays(emptyArray(), expected))
    }

    @Test
    fun secondEmpty() {
        val expected = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertResult(expected, Solution().mergeArrays(expected, emptyArray()))
    }

    @Test
    fun singleOverlappingKey() {
        val nums1 = arrayOf(intArrayOf(1, 5))
        val nums2 = arrayOf(intArrayOf(1, 7))
        assertResult(arrayOf(intArrayOf(1, 12)), Solution().mergeArrays(nums1, nums2))
    }
}
