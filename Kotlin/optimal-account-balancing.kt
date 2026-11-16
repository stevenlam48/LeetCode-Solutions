package optimalaccountbalancing

// Time:  O(n * 2^n), n is the size of debts.
// Space: O(2^n)

class Solution {
    fun minTransfers(transactions: Array<IntArray>): Int {
        val account = HashMap<Int, Int>()
        for (transaction in transactions) {
            account[transaction[0]] = (account[transaction[0]] ?: 0) + transaction[2]
            account[transaction[1]] = (account[transaction[1]] ?: 0) - transaction[2]
        }
        val debts = mutableListOf<Int>()
        for (debt in account.values) {
            if (debt != 0) {
                debts.add(debt)
            }
        }

        val size = 1 shl debts.size
        val dp = IntArray(size)
        val sums = IntArray(size)
        for (i in 0 until size) {
            var bit = 1
            for (j in debts.indices) {
                if ((i and bit) == 0) {
                    val nxt = i or bit
                    sums[nxt] = sums[i] + debts[j]
                    if (sums[nxt] == 0) {
                        dp[nxt] = maxOf(dp[nxt], dp[i] + 1)
                    } else {
                        dp[nxt] = maxOf(dp[nxt], dp[i])
                    }
                }
                bit = bit shl 1
            }
        }
        return debts.size - dp[size - 1]
    }
}
