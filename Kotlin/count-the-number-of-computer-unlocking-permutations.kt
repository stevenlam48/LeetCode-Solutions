package countthenumberofcomputerunlockingpermutations

// Time:  O(n)
// Space: O(1)

// combinatorics
class Solution {
    fun countPermutations(complexity: IntArray): Int {
        val MOD = 1_000_000_007

        val factorial = { n: Int ->
            var result = 1L
            for (i in 1..n) {
                result = (result * i) % MOD
            }
            result
        }

        return if (complexity.drop(1).all { complexity[0] < it }) {
            factorial(complexity.size - 1).toInt()
        } else {
            0
        }
    }
}
