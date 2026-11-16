package designanatmmachine

// Time:  ctor:     O(1)
//        deposit:  O(1)
//        withdraw: O(1)
// Space: O(1)

class ATM {
    private val vals = intArrayOf(20, 50, 100, 200, 500)
    private val cnt = LongArray(vals.size)

    fun deposit(banknotesCount: IntArray) {
        for (i in cnt.indices) {
            cnt[i] += banknotesCount[i]
        }
    }

    fun withdraw(amount: Int): IntArray {
        var remaining = amount
        val result = IntArray(cnt.size)
        for (i in vals.size - 1 downTo 0) {
            result[i] = minOf(remaining.toLong() / vals[i], cnt[i]).toInt()
            remaining -= result[i] * vals[i]
        }
        if (remaining != 0) {
            return intArrayOf(-1)
        }
        for (i in result.indices) {
            cnt[i] -= result[i]
        }
        return result
    }
}
