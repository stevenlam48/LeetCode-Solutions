package findtheoriginaltypedstringi

// Time:  O(n)
// Space: O(1)
class Solution {
    fun possibleStringCount(word: String): Int {
        var result = word.length
        for (i in 0 until word.length - 1) {
            if (word[i] != word[i + 1]) {
                --result
            }
        }
        return result
    }
}
