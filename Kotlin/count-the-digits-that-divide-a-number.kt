package countthedigitsthatdivideanumber

// Time:  O(logn)
// Space: O(1)

// math
class Solution {
    fun countDigits(num: Int): Int {
        var result = 0
        var curr = num
        while (curr != 0) {
            result += if (num % (curr % 10) == 0) 1 else 0
            curr /= 10
        }
        return result
    }
}
