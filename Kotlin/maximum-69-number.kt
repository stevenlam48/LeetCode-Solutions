package maximum69number

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun maximum69Number(num: Int): Int {
        var change = 0
        var curr = num
        var base = 3
        while (curr != 0) {
            if (curr % 10 == 6) {
                change = base
            }
            base *= 10
            curr /= 10
        }
        return num + change
    }
}
