package patchingarray

// Time:  O(s + logn), s is the number of elements in the array
// Space: O(1)

class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
        var result = 0
        var reachable = 0
        for (x in nums) {
            if (x > n) {
                break
            }
            while (reachable < x - 1) {
                ++result
                reachable += reachable + 1
            }
            if (reachable >= n - x) {
                return result
            }
            reachable += x
        }
        ++result
        while (reachable < n - (reachable + 1)) {
            ++result
            reachable += reachable + 1
        }
        return result
    }
}
