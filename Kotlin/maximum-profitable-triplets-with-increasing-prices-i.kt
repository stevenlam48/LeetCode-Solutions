package maximumprofitabletripletswithincreasingpricesi

// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeMap

class Solution {
    fun maxProfit(prices: IntArray, profits: IntArray): Int {
        var result = Int.MIN_VALUE
        val bst1 = TreeMap<Int, Int>()
        val bst2 = TreeMap<Int, Int>()
        for (i in prices.indices) {
            val mx2 = query(bst2, prices[i])
            if (mx2 != Int.MIN_VALUE) {
                result = maxOf(result, mx2 + profits[i])
            }
            update(bst1, prices[i], profits[i])
            val mx1 = query(bst1, prices[i])
            if (mx1 != Int.MIN_VALUE) {
                update(bst2, prices[i], mx1 + profits[i])
            }
        }
        return if (result != Int.MIN_VALUE) result else -1
    }

    private fun query(bst: TreeMap<Int, Int>, k: Int): Int {
        return bst.lowerEntry(k)?.value ?: Int.MIN_VALUE
    }

    private fun update(bst: TreeMap<Int, Int>, k: Int, v: Int) {
        val entry = bst.ceilingEntry(k)
        if (entry != null && entry.key == k) {
            if (entry.value >= v) {
                return
            }
            bst.remove(k)
        } else {
            val previous = bst.lowerEntry(k)
            if (previous != null && previous.value >= v) {
                return
            }
        }
        bst[k] = v
        var next = bst.higherEntry(k)
        while (next != null && next.value <= v) {
            bst.remove(next.key)
            next = bst.higherEntry(k)
        }
    }
}
