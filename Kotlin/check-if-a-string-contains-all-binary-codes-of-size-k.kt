package checkifastringcontainsallbinarycodesofsizek

// Time:  O(n * k)
// Space: O(2^k)

class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val lookup = HashSet<Int>()
        val base = 1 shl k
        if (base > s.length) {
            return false
        }
        var num = 0
        for (i in s.indices) {
            num = (num shl 1) + (s[i] - '0')
            if (i >= k - 1) {
                lookup.add(num)
                num -= (s[i - k + 1] - '0') * (base shr 1)
            }
        }
        return lookup.size == base
    }
}
