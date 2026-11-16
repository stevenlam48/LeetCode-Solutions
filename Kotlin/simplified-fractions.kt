package simplifiedfractions

// Time:  O(n^2 * logn)
// Space: O(n^2)
class Solution {
    fun simplifiedFractions(n: Int): List<String> {
        val lookup = HashSet<Pair<Int, Int>>()
        for (b in 1..n) {
            for (a in 1 until b) {
                val g = gcd(a, b)
                lookup.add(a / g to b / g)
            }
        }
        return lookup.map { "${it.first}/${it.second}" }
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
