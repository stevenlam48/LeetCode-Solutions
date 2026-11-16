package findtheoccurrenceoffirstalmostequalsubstring

// Time:  O(n + m)
// Space: O(n + m)
class Solution {
    fun minStartingIndex(s: String, pattern: String): Int {
        val k = 1
        val z1 = zFunction(pattern + s)
        val reversedPattern = pattern.reversed()
        val reversedS = s.reversed()
        val z2 = zFunction(reversedPattern + reversedS)
        for (i in 0 until reversedS.length - reversedPattern.length + 1) {
            if (z1[pattern.length + i] + k + z2[s.length - i] >= pattern.length) {
                return i
            }
        }
        return -1
    }

    private fun zFunction(s: String): IntArray {
        val z = IntArray(s.length)
        var l = 0
        var r = 0
        for (i in 1 until z.size) {
            if (i <= r) {
                z[i] = minOf(r - i + 1, z[i - l])
            }
            while (i + z[i] < z.size && s[z[i]] == s[i + z[i]]) {
                ++z[i]
            }
            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
        }
        return z
    }
}
