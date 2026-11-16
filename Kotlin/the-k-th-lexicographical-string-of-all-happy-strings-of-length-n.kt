package thekthlexicographicalstringofallhappystringsoflengthn

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getHappyString(n: Int, k0: Int): String {
        var k = k0
        var base = 1 shl (n - 1)
        if (k > 3 * base) {
            return ""
        }
        val result = StringBuilder()
        result.append('a' + (k - 1) / base)
        while (base > 1) {
            k -= ((k - 1) / base) * base
            base = base shr 1
            result.append(
                if ((k - 1) / base == 0) {
                    if (result.last() != 'a') 'a' else 'b'
                } else {
                    if (result.last() != 'c') 'c' else 'b'
                }
            )
        }
        return result.toString()
    }
}
