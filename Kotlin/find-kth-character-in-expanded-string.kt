package findkthcharacterinexpandedstring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun kthCharacter(s: String, k: Long): Char {
        var i = 0
        var position = k
        var length = 0
        while (i < s.length) {
            if (s[i] == ' ') {
                length = 0
                --position
            } else {
                length++
                position -= length.toLong()
            }
            if (position < 0) {
                break
            }
            ++i
        }
        return s[i]
    }
}
