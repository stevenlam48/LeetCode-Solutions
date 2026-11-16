package minimumarraysum

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minArraySum(nums: IntArray, k: Int, op1: Int, op2: Int): Int {
        nums.sort()
        var remainingOp1 = op1
        var remainingOp2 = op2
        var left = 0
        while (left < nums.size && nums[left] < k) {
            ++left
        }
        var right = 0
        while (right < nums.size && nums[right] < 2 * k - 1) {
            ++right
        }
        var j = nums.size - 1
        while (j >= right && remainingOp1 != 0) {
            --remainingOp1
            nums[j] = (nums[j] + 1) / 2
            if (remainingOp2 != 0) {
                --remainingOp2
                nums[j] -= k
            }
            --j
        }
        val lookup = BooleanArray(nums.size)
        var count = 0
        var i = left
        while (i <= j && remainingOp2 != 0) {
            --remainingOp2
            if (k % 2 == 1 && nums[i] % 2 == 0) {
                lookup[i] = true
            }
            nums[i] -= k
            ++i
        }
        while (j >= i && remainingOp1 != 0) {
            --remainingOp1
            if (k % 2 == 1 && nums[j] % 2 == 1) {
                ++count
            }
            nums[j] = (nums[j] + 1) / 2
            --j
        }
        val array = mutableListOf<Pair<Int, Int>>()
        for (index in 0 until i) {
            array.add(Pair(nums[index], index))
        }
        array.sortBy { it.first }
        while (remainingOp1-- > 0) {
            val (value, index) = array.removeAt(array.lastIndex)
            nums[index] = (value + 1) / 2
            if (count != 0 && lookup[index]) {
                --count
                --nums[index]
            }
        }
        return nums.sum()
    }
}
