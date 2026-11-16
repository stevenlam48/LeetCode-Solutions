package checkifnumberisasumofpowersofthree

// Time:  O(logn)
// Space: O(1)
class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        var value = n
        while (value > 0 && value % 3 != 2) {
            value /= 3
        }
        return value == 0
    }
}
