package pushdominoes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun pushDominoes(dominoes: String): String {
        val force = IntArray(dominoes.length)
        var f = 0
        for (i in dominoes.indices) {
            when (dominoes[i]) {
                'R' -> f = dominoes.length
                'L' -> f = 0
                else -> f = maxOf(f - 1, 0)
            }
            force[i] += f
        }
        f = 0
        for (i in dominoes.lastIndex downTo 0) {
            when (dominoes[i]) {
                'L' -> f = dominoes.length
                'R' -> f = 0
                else -> f = maxOf(f - 1, 0)
            }
            force[i] -= f
        }
        return buildString {
            for (value in force) {
                append(if (value == 0) '.' else if (value > 0) 'R' else 'L')
            }
        }
    }
}
