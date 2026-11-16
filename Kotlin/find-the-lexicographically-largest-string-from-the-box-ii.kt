package findthelexicographicallylargeststringfromtheboxii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) {
            return word
        }
        var idx = 0
        var l = 0
        for (i in 1 until word.length) {
            if (word[i] == word[idx + l]) {
                ++l
            } else if (word[i] < word[idx + l]) {
                l = 0
            } else if (word[i] > word[idx + l]) {
                idx = if (word[i - l] >= word[i]) i - l else i
                l = 0
            }
        }
        return word.substring(idx, word.length - maxOf((numFriends - 1) - idx, 0))
    }
}
