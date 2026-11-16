package arraywithelementsnotequaltoaverageofneighbors

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrayWithElementsNotEqualToAverageOfNeighborsTest {
    private val solution = Solution()

    private fun assertValid(nums: IntArray, result: IntArray) {
        assertEquals(nums.sorted(), result.sorted())
        for (i in 1 until result.size - 1) {
            assertNotEquals(
                (result[i - 1] + result[i + 1]) / 2.0,
                result[i].toDouble(),
                "index $i in ${result.toList()}"
            )
        }
    }

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertValid(nums, solution.rearrangeArray(nums.copyOf()))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(6, 2, 0, 9, 7)
        assertValid(nums, solution.rearrangeArray(nums.copyOf()))
    }

    @Test
    fun testDuplicates() {
        val nums = intArrayOf(1, 2, 3, 4)
        assertValid(nums, solution.rearrangeArray(nums.copyOf()))
        val nums2 = intArrayOf(1, 1, 2, 2, 3)
        assertValid(nums2, solution.rearrangeArray(nums2.copyOf()))
    }

    @Test
    fun testSmall() {
        assertValid(intArrayOf(1), solution.rearrangeArray(intArrayOf(1)))
        assertValid(intArrayOf(2, 1), solution.rearrangeArray(intArrayOf(2, 1)))
    }
}
