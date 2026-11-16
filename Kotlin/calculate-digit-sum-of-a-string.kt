package calculatedigitsumofastring

// Time:  O(n + n * (log10(9k)/k) + ... + k)
//      = O((n - (log10(9k)/k)*k)/(1-log10(9k)/k))
//      = O(n / (1-log10(9k)/k)) = O(n) for k >= 2
// Space: O(n)

class Solution {
    fun digitSum(s: String, k: Int): String {
        var current = s
        while (current.length > k) {
            val next = StringBuilder()
            var sum = 0
            for (i in current.indices) {
                sum += current[i] - '0'
                if (i % k == k - 1 || i == current.length - 1) {
                    next.append(sum)
                    sum = 0
                }
            }
            current = next.toString()
        }
        return current
    }
}
