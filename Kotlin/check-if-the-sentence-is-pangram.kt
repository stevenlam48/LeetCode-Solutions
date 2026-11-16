package checkifthesentenceispangram

// Time:  O(n)
// Space: O(26) = O(1)

class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        return sentence.toSet().size == 26
    }
}
