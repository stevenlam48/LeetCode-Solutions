package palindromepermutation
// Time:  O(n)
// Space: O(1)

class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        val bits = BooleanArray(256)
        for (c in s) {
            val index = c.code
            bits[index] = !bits[index]
        }
        return bits.count { it } < 2
    }
}
