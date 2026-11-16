package validkuniquesubarraysii

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun validSubarrays(nums: IntArray, k: Int, l0: Int, r0: Int, q: Int): List<Boolean> {
        val n = nums.size

        fun minLeft(k: Int): IntArray {
            val result = IntArray(n) { n }
            val cnt = HashMap<Int, Int>()
            var left = 0
            for (right in 0 until n) {
                cnt[nums[right]] = (cnt[nums[right]] ?: 0) + 1
                while (cnt.size == k + 1) {
                    val c = cnt[nums[left]]!! - 1
                    if (c == 0) {
                        cnt.remove(nums[left])
                    } else {
                        cnt[nums[left]] = c
                    }
                    ++left
                }
                if (cnt.size == k) {
                    result[right] = left
                }
            }
            return result
        }

        val left = minLeft(k)
        val right = minLeft(k - 1)
        // Fixed seed keeps the port deterministic; the C++ version seeds from the clock.
        val rng = java.util.Random(0)
        val h = HashMap<Int, Long>()
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            if (!h.containsKey(nums[i])) {
                h[nums[i]] = rng.nextLong()
            }
            prefix[i + 1] = prefix[i] xor h[nums[i]]!!
        }
        val result = ArrayList<Boolean>(q)
        var l = l0
        var r = r0
        repeat(q) {
            val valid = (r - l + 1) % 2 == 0 && (prefix[r + 1] xor prefix[l]) == 0L &&
                left[r] <= l && l < right[r]
            result.add(valid)
            val g = if (valid) l + r else r - l
            l = (l xor g) % n
            r = (r xor g) % n
            if (l > r) {
                val tmp = l
                l = r
                r = tmp
            }
        }
        return result
    }
}
