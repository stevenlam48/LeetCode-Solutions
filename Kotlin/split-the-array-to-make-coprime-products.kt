package splitthearraytomakecoprimeproducts

// Time:  O(n * sqrt(r)), r = max(nums)
// Space: O(sqrt(r))

class Solution {
    fun findValidSplit(nums: IntArray): Int {
        fun factorize(value: Int): List<Pair<Int, Int>> {
            var x = value
            val result = mutableListOf<Pair<Int, Int>>()
            var d = 2
            while (d * d <= x) {
                var e = 0
                while (x % d == 0) {
                    x /= d
                    ++e
                }
                if (e > 0) {
                    result.add(Pair(d, e))
                }
                d += if (d == 2) 1 else 2
            }
            if (x > 1) {
                result.add(Pair(x, 1))
            }
            return result
        }

        val right = HashMap<Int, Int>()
        for (x in nums) {
            for ((p, c) in factorize(x)) {
                right[p] = (right[p] ?: 0) + c
            }
        }
        val left = HashMap<Int, Int>()
        var cnt = 0
        for (i in 0 until nums.size - 1) {
            for ((p, c) in factorize(nums[i])) {
                if ((left[p] ?: 0) == 0) {
                    ++cnt
                }
                left[p] = (left[p] ?: 0) + c
                right[p] = (right[p] ?: 0) - c
                if (right[p] == 0) {
                    --cnt
                }
                if (cnt == 0) {
                    return i
                }
            }
        }
        return -1
    }
}
