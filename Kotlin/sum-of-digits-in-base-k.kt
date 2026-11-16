package sumofdigitsinbasek

// Time:  O(logn)
// Space: O(1)
class Solution {
    fun sumBase(n: Int, k: Int): Int {
        var x = n
        var result = 0
        while (x != 0) {
            result += x % k
            x /= k
        }
        return result
    }
}
