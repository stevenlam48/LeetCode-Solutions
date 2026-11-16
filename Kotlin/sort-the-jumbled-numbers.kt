package sortthejumblednumbers

// Time:  O(nlogm + nlogn), m is the max of nums
// Space: O(n)

class Solution {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        fun transform(value: Int): Int {
            if (value == 0) {
                return mapping[0]
            }
            var x = value
            var result = 0
            var base = 1
            while (x != 0) {
                result += mapping[x % 10] * base
                x /= 10
                base *= 10
            }
            return result
        }

        val order = Array(nums.size) { i -> transform(nums[i]) to i }
        order.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        return IntArray(nums.size) { i -> nums[order[i].second] }
    }
}
