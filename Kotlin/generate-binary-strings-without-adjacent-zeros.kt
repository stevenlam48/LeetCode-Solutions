package generatebinarystringswithoutadjacentzeros

// Time:  O(n * 2^n)
// Space: O(n)

// backtracking
class Solution {
    fun validStrings(n: Int): List<String> {
        val result = mutableListOf<String>()
        val curr = StringBuilder()
        fun backtracking(i: Int) {
            if (i == n) {
                result.add(curr.toString())
                return
            }
            if (curr.isEmpty() || curr.last() == '1') {
                curr.append('0')
                backtracking(i + 1)
                curr.setLength(curr.length - 1)
            }
            curr.append('1')
            backtracking(i + 1)
            curr.setLength(curr.length - 1)
        }

        backtracking(0)
        return result
    }
}
