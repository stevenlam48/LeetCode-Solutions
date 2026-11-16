package maximumnumberofalloys

// Time:  O(k * nlogn)
// Space: O(n)

class Solution {
    fun maxNumberOfAlloys(
        n: Int,
        k: Int,
        budget: Int,
        composition: Array<IntArray>,
        stock: IntArray,
        cost: IntArray
    ): Int {
        fun count(machine: IntArray, initialBudget: Int): Int {
            fun cnt(x: Int): Int = stock[x] / machine[x]

            val idxs = (0 until n).sortedBy { cnt(it) }
            var result = cnt(idxs[0])
            var remaining = initialBudget
            var prefix = 0
            var curr = 0
            var discount = 0
            for (i in 0 until n) {
                curr += cost[idxs[i]] * machine[idxs[i]]
                discount += cost[idxs[i]] * (stock[idxs[i]] % machine[idxs[i]])
                if (i + 1 != n && cnt(idxs[i + 1]) - cnt(idxs[i]) == 0) {
                    continue
                }
                prefix += curr
                remaining += discount
                curr = 0
                discount = 0
                val mn = minOf(
                    if (i + 1 < n) cnt(idxs[i + 1]) - cnt(idxs[i]) else Int.MAX_VALUE,
                    remaining / prefix
                )
                if (mn == 0) {
                    break
                }
                remaining -= prefix * mn
                result += mn
            }
            return result
        }

        var result = 0
        for (machine in composition) {
            result = maxOf(result, count(machine, budget))
        }
        return result
    }
}
