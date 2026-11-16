package minimumadditiontomakeintegerbeautiful

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun makeIntegerBeautiful(n: Long, target: Int): Long {
        var total = 0
        var t = n
        while (t != 0L) {
            total += (t % 10).toInt()
            t /= 10
        }
        var m = n
        var l = 0
        while (total > target) {
            do {
                total -= (m % 10).toInt()
                m /= 10
                ++l
            } while (m % 10 == 9L)
            ++total
            ++m
        }
        var p = 1L
        repeat(l) { p *= 10 }
        return m * p - n
    }
}
