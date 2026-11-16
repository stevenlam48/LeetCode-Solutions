package combinationSum2

// Time Complexity: O(n!)
// Space Complexity: O(1)


class Solution {
    fun combinationSum2(num: IntArray, target: Int): Array<IntArray> {
        num.sort()
        val ans = ArrayList<IntArray>()
        val v = ArrayList<Int>()
        dfs(num, target, 0, v, ans)
        return ans.toTypedArray()
    }

    private fun dfs(
        num: IntArray,
        gap: Int,
        begin: Int,
        v: MutableList<Int>,
        ans: MutableList<IntArray>
    ) {
        if (gap == 0) {
            ans.add(v.toIntArray())
            return
        }

        for (i in begin until num.size) {
            if (gap < num[i]) return
            if (i > begin && num[i] == num[i - 1]) continue
            v.add(num[i])
            dfs(num, gap - num[i], i + 1, v, ans)
            v.removeAt(v.size - 1)
        }
    }
}
