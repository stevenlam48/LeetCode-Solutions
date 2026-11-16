package minimumunlockedindicestosortnums

// Time:  O(n)
// Space: O(1)

// sort
class Solution {
    fun minUnlockedIndices(nums: IntArray, locked: IntArray): Int {
        var result = 0
        var mx = 0
        var cnt = 0
        for (i in nums.indices) {
            if (mx < nums[i]) {
                mx = nums[i]
                cnt = 0
            } else if (mx > nums[i]) {
                if (mx != nums[i] + 1) {
                    return -1
                }
                result += cnt
                cnt = 0
            }
            cnt += locked[i]
        }
        return result
    }
}
