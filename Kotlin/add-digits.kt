package adddigits

// Time:  O(1)
// Space: O(1)

class Solution {
    fun addDigits(num: Int): Int {
        return (num - 1) % 9 + 1
    }
}
