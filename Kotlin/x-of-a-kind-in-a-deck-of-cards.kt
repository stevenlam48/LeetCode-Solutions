package xofakindinadeckofcards

// Time:  O(n * (logn)^2)
// Space: O(n)

class Solution {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        val count = HashMap<Int, Int>()
        for (value in deck) count[value] = count.getOrDefault(value, 0) + 1
        var result = 0
        for ((_, frequency) in count) result = gcd(result, frequency)
        return result > 1
    }

    private fun gcd(initialA: Int, initialB: Int): Int {
        var a = initialA
        var b = initialB
        while (b != 0) {
            val temporary = b
            b = a % b
            a = temporary
        }
        return a
    }
}
