package minimumoperationstocollectelements

// Time:  O(n)
// Space: O(k)

// hash table
class Solution {
    fun minOperations(nums: IntArray, k0: Int): Int {
        var k = k0
        val lookup = BooleanArray(k)
        var i = nums.size - 1
        while (i >= 0) {
            if (nums[i] > lookup.size || lookup[nums[i] - 1]) {
                --i
                continue
            }
            lookup[nums[i] - 1] = true
            k -= 1
            if (k == 0) {
                break
            }
            --i
        }
        return nums.size - i
    }
}
