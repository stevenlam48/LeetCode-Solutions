package averagevalueofevennumbersthataredivisiblebythree

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun averageValue(nums: IntArray): Int {
        var total = 0
        var cnt = 0
        for (x in nums) {
            if (x % 6 != 0) {
                continue
            }
            total += x
            ++cnt
        }
        return if (cnt != 0) total / cnt else 0
    }
}
