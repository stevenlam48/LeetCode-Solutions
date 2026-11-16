package combinations

// Time:  O(k * C(n, k))
// Space: O(k)


class Solution {
    fun combine(n: Int, k: Int): Array<IntArray> {
        if (k > n) {
            return emptyArray()
        }
        val nums = IntArray(n) { it + 1 }
        val idxs = IntArray(k) { it }
        val result = ArrayList<IntArray>()
        fun addResult() {
            result.add(IntArray(k) { nums[idxs[it]] })
        }
        addResult()
        while (true) {
            var i = k - 1
            while (i >= 0 && idxs[i] == i + n - k) {
                --i
            }
            if (i < 0) {
                break
            }
            ++idxs[i]
            for (j in i + 1 until k) {
                idxs[j] = idxs[j - 1] + 1
            }
            addResult()
        }
        return result.toTypedArray()
    }
}
