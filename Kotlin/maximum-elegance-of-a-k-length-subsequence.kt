package maximumeleganceofaklengthsubsequence
// Time:  O(nlogk)
// Space: O(k)

import java.util.PriorityQueue
import java.util.TreeSet

class Solution {
    fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
        val comparator = Comparator<IntArray> { a, b ->
            for (i in 0 until minOf(a.size, b.size)) {
                if (a[i] != b[i]) {
                    return@Comparator a[i].compareTo(b[i])
                }
            }
            a.size.compareTo(b.size)
        }
        val heap = PriorityQueue<IntArray>(k, comparator)
        for (item in items) {
            if (heap.size < k) {
                heap.add(item)
            } else if (comparator.compare(item, heap.peek()) > 0) {
                heap.poll()
                heap.add(item)
            }
        }
        val topK = heap.toList().sortedWith(comparator.reversed())
        val selected = java.util.Collections.newSetFromMap(java.util.IdentityHashMap<IntArray, Boolean>())
        selected.addAll(topK)
        val displaced = ArrayDeque<IntArray>()
        for (i in 0 until k) {
            if (items[i] !in selected) {
                displaced.addLast(items[i])
            }
            items[i] = topK[i]
        }
        var index = k
        for (i in k until items.size) {
            if (items[i] !in selected) {
                items[index++] = items[i]
            }
        }
        while (displaced.isNotEmpty()) {
            items[index++] = displaced.removeFirst()
        }
        val lookup = BooleanArray(items.size)
        val stack = arrayListOf<Int>()
        var current = 0L
        var distinct = 0L
        for (item in topK) {
            if (lookup[item[1] - 1]) {
                stack.add(item[0])
            }
            current += item[0]
            if (!lookup[item[1] - 1]) {
                lookup[item[1] - 1] = true
                ++distinct
            }
        }
        val bst = TreeSet<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        val lookup2 = IntArray(items.size)
        for (i in k until items.size) {
            val profit = items[i][0]
            val category = items[i][1]
            if (lookup[category - 1]) {
                continue
            }
            if (lookup2[category - 1] != 0) {
                if (lookup2[category - 1] >= profit) {
                    continue
                }
                bst.remove(lookup2[category - 1] to category)
            }
            bst.add(profit to category)
            lookup2[category - 1] = profit
            if (bst.size > stack.size) {
                val first = bst.first()
                lookup2[first.second - 1] = 0
                bst.remove(first)
            }
        }
        var result = current + distinct * distinct
        for ((profit, _) in bst.descendingSet()) {
            current += profit.toLong() - stack.removeAt(stack.lastIndex)
            ++distinct
            result = maxOf(result, current + distinct * distinct)
        }
        return result
    }
}
