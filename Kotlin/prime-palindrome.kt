package primepalindrome

// Time:  O(n^(1/2) * (logn + n^(1/2)))
// Space: O(logn)

class Solution {
    fun primePalindrome(N: Int): Int {
        if (N in 8..11) {
            return 11
        }
        var i = N.toString().length / 2
        while (i < 100000) {
            val s = i.toString()
            val revS = s.reversed()
            val j = (s + revS.substring(1)).toInt()
            if (j >= N && isPrime(j)) {
                return j
            }
            ++i
        }
        return -1
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2 || num % 2 == 0) {
            return num == 2
        }
        var i = 3
        while (i * i <= num) {
            if (num % i == 0) {
                return false
            }
            i += 2
        }
        return true
    }
}
