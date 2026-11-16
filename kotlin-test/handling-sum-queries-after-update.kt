package handlingsumqueriesafterupdate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HandlingSumQueriesAfterUpdateTest {
    @Test
    fun example1() {
        val nums1 = intArrayOf(1, 0, 1)
        val nums2 = intArrayOf(0, 0, 0)
        val queries = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(2, 1, 0),
            intArrayOf(3, 0, 0)
        )
        assertEquals(listOf(3L), Solution().handleQuery(nums1, nums2, queries))
    }

    @Test
    fun example2() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf(5)
        val queries = arrayOf(
            intArrayOf(2, 0, 0),
            intArrayOf(3, 0, 0)
        )
        assertEquals(listOf(5L), Solution().handleQuery(nums1, nums2, queries))
    }

    @Test
    fun flipAllThenAddAndSum() {
        val nums1 = intArrayOf(0, 0)
        val nums2 = intArrayOf(1, 2)
        val queries = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(3, 0, 0),
            intArrayOf(2, 5, 0),
            intArrayOf(3, 0, 0)
        )
        assertEquals(listOf(3L, 13L), Solution().handleQuery(nums1, nums2, queries))
    }

    @Test
    fun flipTwiceRestores() {
        val nums1 = intArrayOf(1, 1)
        val nums2 = intArrayOf(0, 0)
        val queries = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 0, 0),
            intArrayOf(3, 0, 0),
            intArrayOf(2, 2, 0),
            intArrayOf(3, 0, 0)
        )
        assertEquals(listOf(0L, 4L), Solution().handleQuery(nums1, nums2, queries))
    }

    @Test
    fun partialFlip() {
        val nums1 = intArrayOf(1, 0, 0, 1)
        val nums2 = intArrayOf(0, 0, 0, 0)
        val queries = arrayOf(
            intArrayOf(1, 1, 2),
            intArrayOf(3, 0, 0),
            intArrayOf(2, 3, 0),
            intArrayOf(3, 0, 0)
        )
        assertEquals(listOf(0L, 12L), Solution().handleQuery(nums1, nums2, queries))
    }
}
