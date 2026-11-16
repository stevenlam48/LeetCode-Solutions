package maximumdistancebetweenapairofvalues

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDistanceBetweenAPairOfValuesTest {
    @Test
    fun exampleWithDifferentArrayLengths() {
        val nums1 = intArrayOf(55, 30, 5, 4, 2)
        val nums2 = intArrayOf(100, 20, 10, 10, 5)
        assertEquals(2, Solution().maxDistance(nums1, nums2))
    }

    @Test
    fun exampleWithRepeatedValues() {
        val nums1 = intArrayOf(2, 2, 2)
        val nums2 = intArrayOf(10, 10, 1)
        assertEquals(1, Solution().maxDistance(nums1, nums2))
    }

    @Test
    fun exampleWithLongerSecondArray() {
        val nums1 = intArrayOf(30, 29, 19, 5)
        val nums2 = intArrayOf(25, 25, 25, 25, 25)
        assertEquals(2, Solution().maxDistance(nums1, nums2))
    }

    @Test
    fun noValidPair() {
        val nums1 = intArrayOf(5, 4)
        val nums2 = intArrayOf(3, 2)
        assertEquals(0, Solution().maxDistance(nums1, nums2))
    }
}
