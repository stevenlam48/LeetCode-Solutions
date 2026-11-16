package validkuniquesubarraysi

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun validSubarrays(nums: IntArray, k: Int, queries: Array<IntArray>): List<Boolean> {
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
        val result = ArrayList<Boolean>(queries.size)
        for (q in queries) {
            val l = q[0]
            val r = q[1]
            result.add((r - l + 1) % 2 == 0 && (prefix[r + 1] xor prefix[l]) == 0L &&
                left[r] <= l && l < right[r])
        }
        return result
    }
}
