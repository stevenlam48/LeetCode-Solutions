package applyoperationstomaketwostringsequal

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val inf = Int.MAX_VALUE.toLong()
        var parity = 0
        var curr = 0L
        var prev = 0L
        var j = -1
        for (i in s1.indices) {
            if (s1[i] == s2[i]) {
                continue
            }
            val next = minOf(curr + x, if (j != -1) prev + (i - j) * 2 else inf)
            prev = curr
            curr = next
            j = i
            parity = parity xor 1
        }
        return if (parity == 0) (curr / 2).toInt() else -1
    }
}
