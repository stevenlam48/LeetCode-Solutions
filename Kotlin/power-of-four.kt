package poweroffour
// Time:  O(1)
// Space: O(1)

class Solution {
    fun isPowerOfFour(num: Int): Boolean {
        return num > 0 && (num and (num - 1)) == 0 &&
            (num and 0b01010101010101010101010101010101) == num
    }
}
