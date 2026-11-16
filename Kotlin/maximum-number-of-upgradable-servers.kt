package maximumnumberofupgradableservers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxUpgrades(count: IntArray, upgrade: IntArray, sell: IntArray, money: IntArray): IntArray {
        val result = IntArray(count.size)
        for (i in count.indices) {
            val a = count[i].toLong() * upgrade[i] - money[i]
            val b = (upgrade[i] + sell[i]).toLong()
            val ceilDivide = (a + b - 1) / b
            result[i] = minOf(count[i] - ceilDivide, count[i].toLong()).toInt()
        }
        return result
    }
}
