package mostexpensiveitemthatcannotbebought
// Time:  O(1)
// Space: O(1)

class Solution {
    fun mostExpensiveItem(primeOne: Int, primeTwo: Int): Int {
        return primeOne * primeTwo - primeOne - primeTwo
    }
}
