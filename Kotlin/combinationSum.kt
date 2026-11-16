package combinationSum

// Time Complexity: O(n!)
// Space Complexity: O(1)


class Solution {
    fun combinationSum(candidates: IntArray, target: Int): Array<IntArray> {
        candidates.sort()
        val ans = ArrayList<IntArray>()
        val v = ArrayList<Int>()
        dfs(candidates, target, 0, v, ans)
        return ans.toTypedArray()
    }

    private fun dfs(
        candidates: IntArray,
        gap: Int,
        begin: Int,
        v: MutableList<Int>,
        ans: MutableList<IntArray>
    ) {
        if (gap == 0) {
            ans.add(v.toIntArray())
            return
        }

        for (i in begin until candidates.size) {
            if (gap < candidates[i]) return
            v.add(candidates[i])
            dfs(candidates, gap - candidates[i], i, v, ans)
            v.removeAt(v.size - 1)
        }
    }
}
