package minimummovestobalancecirculararray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minMoves(balance: IntArray): Long {
        val n = balance.size
        var i = 0
        while (i < n) {
            if (balance[i] < 0) {
                break
            }
            ++i
        }
        if (i == n) {
            return 0
        }
        var sum = 0L
        for (x in balance) {
            sum += x
        }
        if (sum < 0) {
            return -1
        }
        var result = 0L
        var d = 1L
        while (d <= n / 2) {
            val c = minOf(balance[((i + d) % n).toInt()] + balance[(((i - d) % n + n) % n).toInt()], -balance[i])
            result += c * d
            balance[i] += c
            if (balance[i] == 0) {
                break
            }
            ++d
        }
        return result
    }
}
