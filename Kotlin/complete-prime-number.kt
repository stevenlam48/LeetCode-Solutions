package completeprimenumber
// Time:  O(logn * sqrt(n))
// Space: O(1)

class Solution {
    fun completePrime(num: Int): Boolean {
        fun isPrime(n: Int): Boolean {
            if (n <= 1 || (n != 2 && n % 2 == 0)) {
                return false
            }
            var i = 3
            while (i <= n) {
                if (i * i > n) {
                    break
                }
                if (n % i == 0) {
                    return false
                }
                i += 2
            }
            return true
        }

        var n = num
        var suffix = 0
        var base = 1
        while (n != 0) {
            if (!isPrime(n)) {
                return false
            }
            suffix += (n % 10) * base
            if (!isPrime(suffix)) {
                return false
            }
            n /= 10
            base *= 10
        }
        return true
    }
}
