package reverseonlyletters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseOnlyLetters(s: String): String {
        val result = StringBuilder()
        var index = s.length - 1
        for (char in s) {
            if (char.isLetter()) {
                while (!s[index].isLetter()) --index
                result.append(s[index])
                --index
            } else {
                result.append(char)
            }
        }
        return result.toString()
    }
}
