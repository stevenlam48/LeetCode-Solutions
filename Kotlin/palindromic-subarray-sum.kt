package palindromicsubarraysum

// Time:  O(n)
// Space: O(n)

// prefix sum, manacher's algorithm
class Solution {
    fun getSum(nums: IntArray): Long {
        fun manacher(s: IntArray): IntArray {
            fun preProcess(s: IntArray): IntArray {
                val ret = ArrayList<Int>()
                ret.add(-1)
                for (i in s.indices) {
                    ret.add(-2)
                    ret.add(s[i])
                }
                ret.add(-2)
                ret.add(-3)
                return ret.toIntArray()
            }

            val t = preProcess(s)
            val n = t.size
            val p = IntArray(n)
            var c = 0
            var r = 0
            for (i in 1 until n - 1) {
                val iMirror = 2 * c - i
                p[i] = if (r > i) minOf(r - i, p[iMirror]) else 0
                while (i + 1 + p[i] < t.size && i - 1 - p[i] >= 0 &&
                    t[i + 1 + p[i]] == t[i - 1 - p[i]]
                ) {
                    p[i]++
                }
                if (i + p[i] > r) {
                    c = i
                    r = i + p[i]
                }
            }
            return p
        }

        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val p = manacher(nums)
        var result = 0L
        for (i in 1 until p.size - 1) {
            result = maxOf(result, prefix[(i + p[i]) / 2] - prefix[(i - p[i]) / 2])
        }
        return result
    }
}
