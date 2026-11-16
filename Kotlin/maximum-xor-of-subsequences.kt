package maximumxorofsubsequences

// Time:  O(nlogr), r = max(nums)
// Space: O(r)

class Solution {
    fun maxXorSubsequences(nums: IntArray): Int {
        val base = ArrayList<Int>()
        for (x0 in nums) {
            var x = x0
            for (b in base) {
                if (x xor b < x) {
                    x = x xor b
                }
            }
            if (x != 0) {
                base.add(x)
            }
        }
        var maxXor = 0
        for (b in base) {
            if (maxXor xor b > maxXor) {
                maxXor = maxXor xor b
            }
        }
        return maxXor
    }
}
