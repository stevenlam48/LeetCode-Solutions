package factorcombinations

// Time:  O(nlogn) = logn * n^(1/2) * n^(1/4) * ... * 1
// Space: O(logn)

class Solution {
    fun getFactors(n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val factors = mutableListOf<Int>()
        getResult(n, result, factors)
        return result
    }

    private fun getResult(n: Int, result: MutableList<List<Int>>, factors: MutableList<Int>) {
        var i = if (factors.isEmpty()) 2 else factors.last()
        while (i <= n / i) {
            if (n % i == 0) {
                factors.add(i)
                factors.add(n / i)
                result.add(factors.toList())
                factors.removeAt(factors.lastIndex)
                getResult(n / i, result, factors)
                factors.removeAt(factors.lastIndex)
            }
            ++i
        }
    }
}
