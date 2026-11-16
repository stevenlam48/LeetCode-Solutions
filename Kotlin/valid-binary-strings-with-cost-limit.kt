package validbinarystringswithcostlimit

// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun generateValidStrings(n: Int, k: Int): List<String> {
        val result = ArrayList<String>()
        val curr = StringBuilder()

        fun backtracking(total: Int) {
            if (curr.length == n) {
                result.add(curr.toString())
                return
            }
            curr.append('0')
            backtracking(total)
            curr.deleteCharAt(curr.lastIndex)
            if ((curr.isEmpty() || curr.last() == '0') && total + curr.length <= k) {
                curr.append('1')
                backtracking(total + curr.length - 1)
                curr.deleteCharAt(curr.lastIndex)
            }
        }

        backtracking(0)
        return result
    }
}
