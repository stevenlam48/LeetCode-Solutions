package numberofadjacentelementswiththesamecolor

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {
        val nums = IntArray(n)
        fun update(i: Int): Int {
            if (nums[i] == 0) {
                return 0
            }
            var cnt = 0
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                ++cnt
            }
            if (i + 1 < n && nums[i + 1] == nums[i]) {
                ++cnt
            }
            return cnt
        }

        val result = IntArray(queries.size)
        var curr = 0
        for (idx in queries.indices) {
            curr -= update(queries[idx][0])
            nums[queries[idx][0]] = queries[idx][1]
            curr += update(queries[idx][0])
            result[idx] = curr
        }
        return result
    }
}
