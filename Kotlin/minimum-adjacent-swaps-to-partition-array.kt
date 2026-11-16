package minimumadjacentswapstopartitionarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minAdjacentSwaps(nums: IntArray, a: Int, b: Int): Int {
        val mod = 1_000_000_007
        var result = 0
        var count1 = 0
        var count2 = 0
        for (x in nums) {
            if (x < a) {
                result = (result + count1 + count2) % mod
            } else if (x <= b) {
                ++count1
                result = (result + count2) % mod
            } else {
                ++count2
            }
        }
        return result
    }
}
