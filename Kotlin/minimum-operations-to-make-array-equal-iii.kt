package minimumoperationstomakearrayequaliii

// Time:  O(nlogr), r = max(nums)
// Space: O(n)

class Solution {
    fun minOperations(nums: IntArray): Long {
        val cnt = HashMap<Int, HashMap<Int, Int>>()
        for (x in nums) {
            val length = 32 - Integer.numberOfLeadingZeros(x)
            val frequencies = cnt.getOrPut(length) { HashMap() }
            frequencies[x] = (frequencies[x] ?: 0) + 1
        }
        val ones = cnt[1]?.get(1)
        if (ones != null && ones == nums.size) {
            return 0
        }
        val candidates = ArrayList<Int>()
        for ((length, frequencies) in cnt) {
            if (length == 1) {
                continue
            }
            var total = 0
            for (count in frequencies.values) {
                total += count
            }
            for ((x, count) in frequencies) {
                if (total - 2 * count >= 0) {
                    continue
                }
                candidates.add(x)
                break
            }
        }
        var result = nums.size
        for (target in candidates) {
            var c = 0
            for (x in nums) {
                if (x == target) {
                    continue
                }
                if (x % target == 0 || target % x == 0) {
                    ++c
                } else {
                    c += 2
                }
            }
            result = minOf(result, c)
        }
        return result.toLong()
    }
}
