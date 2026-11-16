package kthancestorofatreenode

// Time:  ctor: O(n * logh)
//        get:  O(logh)
// Space: O(n * logh)

class TreeAncestor(n: Int, parent: IntArray) {
    private val parent_: MutableList<MutableList<Int>> = ArrayList()

    init {
        val q = ArrayList<Int>()
        for (p in parent) {
            val row = ArrayList<Int>()
            if (p != -1) {
                row.add(p)
            }
            parent_.add(row)
            if (p != -1) {
                q.add(parent_.size - 1)
            }
        }
        var i = 0
        while (q.isNotEmpty()) {
            val newQ = ArrayList<Int>()
            for (curr in q) {
                if (i >= parent_[parent_[curr][i]].size) {
                    continue
                }
                parent_[curr].add(parent_[parent_[curr][i]][i])
                newQ.add(curr)
            }
            q.clear()
            q.addAll(newQ)
            ++i
        }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var curr = node
        var remaining = k
        while (remaining != 0) {
            val low = remaining and -remaining
            val i = Integer.numberOfTrailingZeros(low)
            if (i >= parent_[curr].size) {
                return -1
            }
            curr = parent_[curr][i]
            remaining -= low
        }
        return curr
    }
}
