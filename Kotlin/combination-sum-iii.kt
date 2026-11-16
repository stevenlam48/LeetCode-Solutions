package combinationsumiii

// Time:  O(k * C(n, k))
// Space: O(k)


class Solution {
    fun combinationSum3(k: Int, n: Int): Array<IntArray> {
        val res = ArrayList<IntArray>()
        val combination = ArrayList<Int>()
        combinationSum3(res, combination, 1, k, n)
        return res.toTypedArray()
    }

    private fun combinationSum3(
        res: MutableList<IntArray>,
        combination: MutableList<Int>,
        start: Int,
        k: Int,
        n: Int
    ) {
        if (k == 0 && n == 0) {
            res.add(combination.toIntArray())
            return
        } else if (k < 0) {
            return
        }

        var i = start
        while (i < 10 && n >= k * i + k * (k - 1) / 2) {
            combination.add(i)
            combinationSum3(res, combination, i + 1, k - 1, n - i)
            combination.removeAt(combination.size - 1)
            ++i
        }
    }
}
