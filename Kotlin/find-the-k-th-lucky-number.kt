package findthekthluckynumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun kthLuckyNumber(k0: Int): String {
        var k = k0 + 1
        val result = StringBuilder()
        while (k != 1) {
            result.append(if (k and 1 != 0) '7' else '4')
            k = k shr 1
        }
        return result.reverse().toString()
    }
}
