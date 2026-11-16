package dinnerplatestacks

import java.util.PriorityQueue

// Time:  push: O(logn)
//        pop:  O(1), amortized
//        popAtStack: O(logn)
// Space: O(n * c)

class DinnerPlates(private val c: Int) {
    private val stks = mutableListOf<MutableList<Int>>()
    private val minHeap = PriorityQueue<Int>()

    fun push(`val`: Int) {
        if (minHeap.isNotEmpty()) {
            val l = minHeap.poll()
            if (l < stks.size) {
                stks[l].add(`val`)
                return
            }
            minHeap.clear()  // nothing is valid in min heap
        }
        if (stks.isEmpty() || stks.last().size == c) {
            stks.add(mutableListOf())
        }
        stks.last().add(`val`)
    }

    fun pop(): Int {
        while (stks.isNotEmpty() && stks.last().isEmpty()) {
            stks.removeAt(stks.size - 1)
        }
        if (stks.isEmpty()) {
            return -1
        }
        return stks.last().removeAt(stks.last().size - 1)
    }

    fun popAtStack(index: Int): Int {
        if (index >= stks.size || stks[index].isEmpty()) {
            return -1
        }
        minHeap.add(index)
        return stks[index].removeAt(stks[index].size - 1)
    }
}
