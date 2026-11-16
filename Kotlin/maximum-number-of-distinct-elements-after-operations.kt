package maximumnumberofdistinctelementsafteroperations

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        var result = 0
        nums.sort()
        var curr = Int.MIN_VALUE
        for (x in nums) {
            if (curr > x + k) {
                continue
            }
            curr = maxOf(curr, x - k) + 1
            ++result
        }
        return result
    }
}
