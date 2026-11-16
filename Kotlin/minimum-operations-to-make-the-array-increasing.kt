package minimumoperationstomakethearrayincreasing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        var prev = 0
        for (curr in nums) {
            if (prev < curr) {
                prev = curr
                continue
            }
            ++prev
            result += prev - curr
        }
        return result
    }
}
