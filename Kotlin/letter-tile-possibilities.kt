package lettertilepossibilities

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val fact = DoubleArray(tiles.length + 1)
        fact[0] = 1.0
        for (i in 1 until fact.size) {
            fact[i] = fact[i - 1] * i
        }
        val count = IntArray(26)
        for (c in tiles) {
            ++count[c - 'A']
        }

        var coeff = DoubleArray(tiles.length + 1)
        coeff[0] = 1.0
        for (i in 0 until 26) {
            val newCoeff = DoubleArray(coeff.size)
            for (j in coeff.indices) {
                for (k in 0..count[i]) {
                    if (k + j >= newCoeff.size) {
                        break
                    }
                    newCoeff[j + k] += coeff[j] * 1.0 / fact[k]
                }
            }
            coeff = newCoeff
        }

        var result = 0
        for (i in 1 until coeff.size) {
            result += Math.round(coeff[i] * fact[i]).toInt()
        }
        return result
    }
}
