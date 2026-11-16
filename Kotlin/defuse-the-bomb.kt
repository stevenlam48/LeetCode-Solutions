package defusethebomb

// Time:  O(n)
// Space: O(1)
class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val result = IntArray(code.size)
        if (k == 0) return result
        var left = 1
        var right = k
        var count = k
        if (count < 0) {
            count = -count
            left = code.size - count
            right = code.size - 1
        }
        var total = 0
        for (i in left..right) total += code[i]
        for (i in code.indices) {
            result[i] = total
            total -= code[left++ % code.size]
            total += code[++right % code.size]
        }
        return result
    }
}
