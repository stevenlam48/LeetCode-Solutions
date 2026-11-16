package removeadjacentalmostequalcharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun removeAlmostEqualCharacters(word: String): Int {
        var result = 0
        var i = 0
        while (i + 1 + result < word.length) {
            if (kotlin.math.abs(word[i + 1 + result].code - word[i + result].code) <= 1) {
                ++result
            }
            ++i
        }
        return result
    }
}
