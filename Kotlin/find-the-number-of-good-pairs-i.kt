package findthenumberofgoodpairsi

// Time:  O(rlogr + n + m)
// Space: O(r)

// number theory, freq table
class Solution {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
        val cnt2 = HashMap<Int, Long>()
        for (x in nums2) {
            cnt2[k * x] = (cnt2[k * x] ?: 0L) + 1
        }
        val cnt = LongArray(nums1.max() + 1)
        for ((x, c) in cnt2) {
            var i = 1
            while (i.toLong() * x < cnt.size) {
                cnt[i * x] += c
                ++i
            }
        }
        var result = 0L
        for (x in nums1) {
            result += cnt[x]
        }
        return result.toInt()
    }
}
