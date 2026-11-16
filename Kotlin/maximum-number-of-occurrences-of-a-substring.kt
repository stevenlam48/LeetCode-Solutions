package maximumnumberofoccurrencesofasubstring
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val m = 1000000007L
        val p = 113L
        val power = modPow(p, (minSize - 1).toLong(), m)
        var rollingHash = 0L
        var left = 0
        val lookup = HashMap<Long, Int>()
        val count = HashMap<Char, Int>()
        for (right in s.indices) {
            count[s[right]] = count.getOrDefault(s[right], 0) + 1
            if (right - left + 1 > minSize) {
                count[s[left]] = count.getValue(s[left]) - 1
                rollingHash = (rollingHash + m - (s[left].code * power) % m) % m
                if (count.getValue(s[left]) == 0) {
                    count.remove(s[left])
                }
                ++left
            }
            rollingHash = ((rollingHash * p) % m + s[right].code) % m
            if (right - left + 1 == minSize && count.size <= maxLetters) {
                lookup[rollingHash] = lookup.getOrDefault(rollingHash, 0) + 1
            }
        }
        return lookup.values.maxOrNull() ?: 0
    }

    private fun modPow(a: Long, b: Long, m: Long): Long {
        var base = a % m
        var exponent = b
        var result = 1L
        while (exponent != 0L) {
            if ((exponent and 1L) != 0L) {
                result = (result * base) % m
            }
            base = (base * base) % m
            exponent = exponent shr 1
        }
        return result
    }
}
