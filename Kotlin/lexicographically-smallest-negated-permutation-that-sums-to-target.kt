package lexicographicallysmallestnegatedpermutationthatsumstotarget

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lexSmallestNegatedPerm(n: Int, target: Long): IntArray {
        val count = { n: Int -> (n + 1L) * n / 2 }

        val total = count(n)
        var t = target
        if (Math.abs(t) > total || (t - total) % 2 != 0L) {
            return IntArray(0)
        }
        val result = IntArray(n)
        var left = 0
        var right = n - 1
        for (i in n downTo 1) {
            if (t - (-i) <= count(i - 1)) {
                t -= -i
                result[left++] = -i
            } else {
                t -= i
                result[right--] = i
            }
        }
        return result
    }
}
