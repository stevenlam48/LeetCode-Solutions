package consecutivenumberssum
// Time:  O(sqrt(n))
// Space: O(1)

class Solution {
    fun consecutiveNumbersSum(N: Int): Int {
        var n = N
        var result = 1
        while (n % 2 == 0) {
            n /= 2
        }
        var i = 3
        while (i * i <= n) {
            var count = 0
            while (n % i == 0) {
                n /= i
                ++count
            }
            result *= count + 1
            i += 2
        }
        if (n != 1) {
            result *= 2
        }
        return result
    }
}
