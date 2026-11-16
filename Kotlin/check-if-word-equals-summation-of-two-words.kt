package checkifwordequalssummationoftwowords

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        return stoi(firstWord) + stoi(secondWord) == stoi(targetWord)
    }

    private fun stoi(s: String): Int {
        var result = 0
        for (c in s) {
            result = result * 10 + (c - 'a')
        }
        return result
    }
}
