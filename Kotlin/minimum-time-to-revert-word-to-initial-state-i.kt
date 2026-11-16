package minimumtimetorevertwordtoinitialstatei

// Time:  O(n)
// Space: O(n)

private fun zFunction(s: String): IntArray {
    val z = IntArray(s.length)
    var left = 0
    var right = 0
    for (i in 1 until s.length) {
        if (i <= right) {
            z[i] = minOf(right - i + 1, z[i - left])
        }
        while (i + z[i] < s.length && s[z[i]] == s[i + z[i]]) {
            ++z[i]
        }
        if (i + z[i] - 1 > right) {
            left = i
            right = i + z[i] - 1
        }
    }
    return z
}

class Solution {
    fun minimumTimeToInitialState(word: String, k: Int): Int {
        val z = zFunction(word)
        var i = k
        while (i < word.length) {
            if (z[i] == word.length - i) {
                return i / k
            }
            i += k
        }
        return (word.length + k - 1) / k
    }
}
