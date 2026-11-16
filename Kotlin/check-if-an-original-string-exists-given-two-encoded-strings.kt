package checkifanoriginalstringexistsgiventwoencodedstrings

// Time:  O(m * n * k), k is the max number of consecutive digits in s1 and s2
// Space: O(m * n * k)

class Solution {
    fun possiblyEquals(s1: String, s2: String): Boolean {
        val lookup = Array(s1.length + 1) { Array(s2.length + 1) { HashMap<Int, Boolean>() } }
        return memoization(s1, s2, 0, 0, 0, lookup)
    }

    private fun memoization(
        s1: String,
        s2: String,
        i: Int,
        j: Int,
        k: Int,
        lookup: Array<Array<HashMap<Int, Boolean>>>
    ): Boolean {
        lookup[i][j][k]?.let { return it }
        var result = false
        if (i == s1.length && j == s2.length) {
            result = k == 0
        } else if (i != s1.length && s1[i].isDigit()) {
            var ni = i + 1
            while (ni < s1.length && s1[ni].isDigit()) {
                ++ni
            }
            for (x in optimizedPossibleNumbers(s1.substring(i, ni))) {
                if (memoization(s1, s2, ni, j, k + x, lookup)) {
                    result = true
                    break
                }
            }
        } else if (j != s2.length && s2[j].isDigit()) {
            var nj = j + 1
            while (nj < s2.length && s2[nj].isDigit()) {
                ++nj
            }
            for (x in optimizedPossibleNumbers(s2.substring(j, nj))) {
                if (memoization(s1, s2, i, nj, k - x, lookup)) {
                    result = true
                    break
                }
            }
        } else if (k < 0) {
            result = if (i != s1.length) memoization(s1, s2, i + 1, j, k + 1, lookup) else false
        } else if (k > 0) {
            result = if (j != s2.length) memoization(s1, s2, i, j + 1, k - 1, lookup) else false
        } else {
            result = i != s1.length && j != s2.length && s1[i] == s2[j] &&
                memoization(s1, s2, i + 1, j + 1, k, lookup)
        }
        lookup[i][j][k] = result
        return result
    }

    private fun optimizedPossibleNumbers(s: String): List<Int> {
        val result = mutableListOf(s.toInt())
        if (s.length >= 2) {
            if (s[1] != '0') {
                result.add(s.substring(0, 1).toInt() + s.substring(1).toInt())
            }
        }
        if (s.length >= 3) {
            if (s[2] != '0') {
                result.add(s.substring(0, 2).toInt() + s.substring(2).toInt())
                if (s[1] != '0') {
                    result.add(
                        s.substring(0, 1).toInt() +
                            s.substring(1, 2).toInt() +
                            s.substring(2).toInt()
                    )
                }
            }
        }
        return result
    }
}
