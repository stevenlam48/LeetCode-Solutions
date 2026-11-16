package guessthemajorityinahiddenarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessTheMajorityInAHiddenArrayTest {
    private class FakeReader(private val nums: IntArray) : ArrayReader {
        override fun length(): Int = nums.size

        override fun query(a: Int, b: Int, c: Int, d: Int): Int {
            val values = intArrayOf(nums[a], nums[b], nums[c], nums[d])
            var best = values[0]
            var bestCount = 0
            for (v in values) {
                var count = 0
                for (w in values) {
                    if (w == v) {
                        ++count
                    }
                }
                if (count > bestCount) {
                    bestCount = count
                    best = v
                }
            }
            return best
        }
    }

    private fun majorityIndex(nums: IntArray, result: Int) {
        if (result != -1) {
            var count = 0
            for (x in nums) {
                if (x == nums[result]) {
                    ++count
                }
            }
            assertEquals(true, count * 2 > nums.size)
        }
        assertEquals(result, Solution().guessMajority(FakeReader(nums)))
    }

    @Test
    fun example1() {
        majorityIndex(intArrayOf(1, 1, 1, 1, 1, 2, 2), 3)
    }

    @Test
    fun allSame() {
        majorityIndex(intArrayOf(5, 5, 5, 5, 5), 3)
    }

    @Test
    fun minorityAtStart() {
        majorityIndex(intArrayOf(2, 1, 1, 1, 1, 1, 1), 3)
    }

    @Test
    fun majorityOnlyInSecondHalf() {
        majorityIndex(intArrayOf(9, 9, 9, 9, 2, 2, 2), 3)
    }

    @Test
    fun twoElements() {
        majorityIndex(intArrayOf(3, 3, 3, 3, 3, 7), 3)
    }
}
