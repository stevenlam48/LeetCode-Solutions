package countintegersinintervals

// Time:  ctor:  O(1)
//        add:   O(logn), amortized
//        count: O(1)
// Space: O(n)

import java.util.TreeMap

class CountIntervals {
    private val bst = TreeMap<Int, Int>()
    private var cnt = 0

    fun add(left: Int, right: Int) {
        var newLeft = left
        var newRight = right
        var nextKey = bst.higherKey(newLeft)
        val previousKey = bst.lowerKey(newLeft)
        if (previousKey != null && bst[previousKey]!! + 1 >= newLeft) {
            newLeft = previousKey
            nextKey = previousKey
        }
        while (nextKey != null && newRight + 1 >= nextKey) {
            newRight = maxOf(newRight, bst[nextKey]!!)
            cnt -= bst[nextKey]!! - nextKey + 1
            bst.remove(nextKey)
            nextKey = bst.higherKey(nextKey)
        }
        bst[newLeft] = newRight
        cnt += newRight - newLeft + 1
    }

    fun count(): Int = cnt
}
