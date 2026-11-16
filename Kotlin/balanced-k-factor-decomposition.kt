package balancedkfactordecomposition

// Time:  precompute: O(rlogr)
//        runtime:    O(k * (logn)^(k - 1))
// Space: O(rlogr)

private const val MAX_N = 100000

private fun factors(n: Int): List<List<Int>> {
    val result = List(n + 1) { mutableListOf<Int>() }
    for (i in 1..n) {
        var j = i
        while (j <= n) {
            result[j].add(i)
            j += i
        }
    }
    return result
}

private val FACTORS = factors(MAX_N)

class Solution {
    fun minDifference(n: Int, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val curr = mutableListOf<Int>()
        lateinit var backtracking: (Int) -> Unit
        backtracking = { remain ->
            val start = if (curr.isNotEmpty()) curr.last() else 1
            if (curr.size == k - 1) {
                if (remain >= start) {
                    curr.add(remain)
                    if (result.isEmpty() || result.last() - result.first() > curr.last() - curr.first()) {
                        result.clear()
                        result.addAll(curr)
                    }
                    curr.removeAt(curr.lastIndex)
                }
            } else {
                val divisors = FACTORS[remain]
                val found = divisors.binarySearch(start)
                val first = if (found >= 0) found else -found - 1
                for (i in first until divisors.size) {
                    curr.add(divisors[i])
                    backtracking(remain / divisors[i])
                    curr.removeAt(curr.lastIndex)
                }
            }
        }
        backtracking(n)
        return result.toIntArray()
    }
}
