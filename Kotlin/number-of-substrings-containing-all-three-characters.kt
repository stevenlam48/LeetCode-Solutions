package numberofsubstringscontainingallthreecharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfSubstrings(s: String): Int {
        var result = 0
        val left = IntArray(3) { -1 }
        for (right in s.indices) {
            left[s[right] - 'a'] = right
            result += left.min() + 1
        }
        return result
    }
}
