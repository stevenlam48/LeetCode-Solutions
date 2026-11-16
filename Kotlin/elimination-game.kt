package eliminationgame

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun lastRemaining(n: Int): Int {
        var start = 1
        var remaining = n
        var step = 2
        var direction = 1
        while (remaining > 1) {
            start += direction * (step * (remaining / 2) - step / 2)
            remaining /= 2
            step *= 2
            direction *= -1
        }
        return start
    }
}
