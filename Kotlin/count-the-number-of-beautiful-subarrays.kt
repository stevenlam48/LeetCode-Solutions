package countthenumberofbeautifulsubarrays

// Time:  O(n)
// Space: O(n)

// freq table, combinatorics
class Solution {
    fun beautifulSubarrays(nums: IntArray): Long {
        val cnt = HashMap<Long, Int>()
        cnt[0L] = 1
        var result = 0L
        var curr = 0L
        for (x in nums) {
            curr = curr xor x.toLong()
            val c = cnt.getOrDefault(curr, 0)
            result += c
            cnt[curr] = c + 1
        }
        return result
    }
}
