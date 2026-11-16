package ransomnote
// Time:  O(n)
// Space: O(1)
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val counts = IntArray(26)
        var letters = 0
        for (c in ransomNote) {
            if (counts[c - 'a']++ == 0) {
                letters++
            }
        }
        for (c in magazine) {
            if (--counts[c - 'a'] == 0 && --letters == 0) {
                break
            }
        }
        return letters == 0
    }
}
