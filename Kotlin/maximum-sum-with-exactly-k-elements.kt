package maximumsumwithexactlykelements
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        return nums.max() * k + k * (k - 1) / 2
    }
}
