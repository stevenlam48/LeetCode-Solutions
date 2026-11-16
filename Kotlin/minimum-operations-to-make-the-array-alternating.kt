package minimumoperationstomakethearrayalternating

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun minimumOperations(nums: IntArray): Int {
        val even = HashMap<Int, Int>()
        var i = 0
        while (i < nums.size) {
            even.merge(nums[i], 1, Int::plus)
            i += 2
        }
        val odd = HashMap<Int, Int>()
        i = 1
        while (i < nums.size) {
            odd.merge(nums[i], 1, Int::plus)
            i += 2
        }

        fun findTop1AndTop2(cnt: Map<Int, Int>): Pair<Int, Int> {
            var top1 = -1
            var top2 = -1
            for ((k, v) in cnt) {
                if (top1 == -1 || v >= cnt.getValue(top1)) {
                    top2 = top1
                    top1 = k
                } else if (top2 == -1 || v > cnt.getValue(top2)) {
                    top2 = k
                }
            }
            return top1 to top2
        }

        val (evenTop1, evenTop2) = findTop1AndTop2(even)
        val (oddTop1, oddTop2) = findTop1AndTop2(odd)
        if (evenTop1 != oddTop1) {
            return nums.size - (even[evenTop1] ?: 0) - (if (oddTop1 != -1) odd.getValue(oddTop1) else 0)
        }
        return minOf(
            nums.size - (even[evenTop1] ?: 0) - (if (oddTop2 != -1) odd.getValue(oddTop2) else 0),
            nums.size - (odd[oddTop1] ?: 0) - (if (evenTop2 != -1) even.getValue(evenTop2) else 0)
        )
    }
}
