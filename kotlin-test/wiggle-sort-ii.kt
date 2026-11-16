package wigglesortii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WiggleSortIiTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertValidWiggle(intArrayOf(1, 5, 1, 1, 6, 4))
    }

    @Test
    fun example2() {
        assertValidWiggle(intArrayOf(1, 3, 2, 2, 3, 1))
    }

    @Test
    fun manyDuplicates() {
        assertValidWiggle(intArrayOf(1, 1, 2, 1, 2, 2, 1))
    }

    @Test
    fun twoValues() {
        assertValidWiggle(intArrayOf(4, 5, 5, 6))
    }

    @Test
    fun smallInputs() {
        assertValidWiggle(intArrayOf(1))
        assertValidWiggle(intArrayOf(2, 1))
    }

    @Test
    fun oddLength() {
        assertValidWiggle(intArrayOf(1, 2, 3, 4, 5, 6, 7))
    }

    private fun assertValidWiggle(original: IntArray) {
        val nums = original.copyOf()
        solution.wiggleSort(nums)
        for (i in 0 until nums.size - 1) {
            if (i % 2 == 0) {
                assertTrue(nums[i] < nums[i + 1], "expected nums[$i] < nums[${i + 1}]: ${nums.toList()}")
            } else {
                assertTrue(nums[i] > nums[i + 1], "expected nums[$i] > nums[${i + 1}]: ${nums.toList()}")
            }
        }
        assertArrayEquals(original.sortedArray(), nums.sortedArray())
    }
}
