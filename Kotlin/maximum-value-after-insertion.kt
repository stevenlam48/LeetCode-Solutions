package maximumvalueafterinsertion

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxValue(n: String, x: Int): String {
        val digit = '0' + x
        val check: (Int) -> Boolean = if (n[0] != '-') {
            { i -> digit > n[i] }
        } else {
            { i -> digit < n[i] }
        }
        var i = 0
        while (i < n.length && !check(i)) {
            ++i
        }
        return n.substring(0, i) + digit + n.substring(i)
    }
}
