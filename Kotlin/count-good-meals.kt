package countgoodmeals

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countPairs(deliciousness: IntArray): Int {
        val mod = 1000000007
        val maxPow = 31 - deliciousness.max().countLeadingZeroBits() + 1
        val cnt = HashMap<Int, Int>()
        var result = 0
        for (d in deliciousness) {
            var p = 1
            for (i in 0..maxPow) {
                result = (result + cnt.getOrDefault(p - d, 0)) % mod
                p = p shl 1
            }
            cnt[d] = cnt.getOrDefault(d, 0) + 1
        }
        return result
    }
}
