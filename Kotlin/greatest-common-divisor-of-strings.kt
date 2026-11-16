package greatestcommondivisorofstrings

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1.isEmpty() || str2.isEmpty()) {
            return ""
        }
        val c = gcd(str1.length, str2.length)
        val result = str1.substring(0, c)
        return if (check(str1, result) && check(str2, result)) result else ""
    }

    private fun check(s: String, common: String): Boolean {
        var i = 0
        for (c in s) {
            if (c != common[i]) {
                return false
            }
            i = (i + 1) % common.length
        }
        return true
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val tmp = y
            y = x % y
            x = tmp
        }
        return x
    }
}
