package smallestnumberininfiniteset
// Time:  ctor:        O(1)
//        popSmallest: O(logn)
//        addBack:     O(logn)
// Space: O(n)

import java.util.TreeSet

class SmallestInfiniteSet {
    private var n = 1
    private val bst = TreeSet<Int>()

    fun popSmallest(): Int {
        if (bst.isNotEmpty()) {
            return bst.pollFirst()
        }
        return n++
    }

    fun addBack(num: Int) {
        if (num >= n) {
            return
        }
        bst.add(num)
    }
}
