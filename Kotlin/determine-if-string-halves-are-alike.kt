package determineifstringhalvesarealike

// Time:  O(n)
// Space: O(1)

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var count1 = 0
        var count2 = 0
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] in vowels) {
                ++count1
            }
            if (s[right] in vowels) {
                ++count2
            }
            ++left
            --right
        }
        return count1 == count2
    }
}
