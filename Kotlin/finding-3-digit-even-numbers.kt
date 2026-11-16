package finding3digitevennumbers
// Time:  O(1) ~ O(n), n is 10^3
// Space: O(1)

class Solution {
    fun findEvenNumbers(digits: IntArray): List<Int> {
        val cnt = IntArray(10)
        for (d in digits) {
            ++cnt[d]
        }
        val result = mutableListOf<Int>()
        val curr = mutableListOf<Int>()
        backtracking(curr, cnt, result)
        return result
    }

    private fun backtracking(curr: MutableList<Int>, cnt: IntArray, result: MutableList<Int>) {
        if (curr.size == 3) {
            result.add(curr.fold(0) { total, x -> total * 10 + x })
            return
        }
        for (i in cnt.indices) {
            if (cnt[i] == 0 || (curr.isEmpty() && i == 0) || (curr.size == 2 && i % 2 != 0)) {
                continue
            }
            --cnt[i]
            curr.add(i)
            backtracking(curr, cnt, result)
            curr.removeAt(curr.lastIndex)
            ++cnt[i]
        }
    }
}
