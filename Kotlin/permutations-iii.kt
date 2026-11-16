package permutationsiii
// Time:  O(n * n!)
// Space: O(n)

class Solution {
    fun permute(n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val curr = ArrayList<Int>(n)
        fun backtracking(lookup: Int) {
            if (curr.size == n) {
                result.add(curr.toList())
                return
            }
            for (i in 1..n) {
                if ((lookup and (1 shl (i - 1))) != 0 ||
                    (curr.isNotEmpty() && curr.last() % 2 == i % 2)
                ) {
                    continue
                }
                curr.add(i)
                backtracking(lookup xor (1 shl (i - 1)))
                curr.removeAt(curr.lastIndex)
            }
        }
        backtracking(0)
        return result
    }
}
