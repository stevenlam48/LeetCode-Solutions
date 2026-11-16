package countsquaresumtriples

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun countTriples(n: Int): Int {
        val lookup = HashSet<Int>()
        for (i in 1..n) {
            lookup.add(i * i)
        }
        var result = 0
        for (i in 1..n) {
            for (j in 1..n) {
                if (lookup.contains(i * i + j * j)) {
                    ++result
                }
            }
        }
        return result
    }
}
