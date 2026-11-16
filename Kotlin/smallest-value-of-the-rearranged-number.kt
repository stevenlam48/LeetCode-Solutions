package smallestvalueoftherearrangednumber

import kotlin.math.abs

// Time:  O(d), d is the number of digits
// Space: O(d)

class Solution {
    fun smallestNumber(num: Long): Long {
        val sign = if (num >= 0) 1L else -1L
        val nums = abs(num).toString().toCharArray()
        inplaceCountingSort(nums, sign == -1L)
        val it = nums.indexOfFirst { it != '0' }
        if (it != -1) {
            val tmp = nums[0]
            nums[0] = nums[it]
            nums[it] = tmp
        }
        return sign * String(nums).toLong()
    }

    private fun inplaceCountingSort(nums: CharArray, isReverse: Boolean) {
        val count = IntArray(10)
        for (num in nums) {
            ++count[num - '0']
        }
        var k = 0
        for (d in 0..9) {
            repeat(count[d]) {
                nums[k++] = '0' + d
            }
        }
        if (isReverse) {
            nums.reverse()
        }
    }
}
