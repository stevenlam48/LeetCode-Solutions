package designskiplist

import java.util.Random

// Time:  O(logn) on average for each operation
// Space: O(n)

class Skiplist {
    private class SkipNode(var num: Int, level: Int) {
        val nexts = ArrayList<SkipNode?>(level).apply {
            repeat(level) { add(null) }
        }
    }

    private val random = Random()
    private var len = 0
    private val head = SkipNode(-1, 0)

    fun search(target: Int): Boolean = find(target, findPrevNodes(target)) != null

    fun add(num: Int) {
        val node = SkipNode(num, randomLevel())
        while (head.nexts.size < node.nexts.size) {
            head.nexts.add(null)
        }
        val prevs = findPrevNodes(num)
        for (i in node.nexts.indices) {
            node.nexts[i] = prevs[i]!!.nexts[i]
            prevs[i]!!.nexts[i] = node
        }
        ++len
    }

    fun erase(num: Int): Boolean {
        val prevs = findPrevNodes(num)
        val curr = find(num, prevs) ?: return false
        --len
        for (i in curr.nexts.size - 1 downTo 0) {
            prevs[i]!!.nexts[i] = curr.nexts[i]
            if (head.nexts[i] == null) {
                head.nexts.removeAt(head.nexts.size - 1)
            }
        }
        return true
    }

    fun size(): Int = len

    private fun find(num: Int, prevs: List<SkipNode?>): SkipNode? {
        if (prevs.isNotEmpty()) {
            val candidate = prevs[0]!!.nexts[0]
            if (candidate != null && candidate.num == num) {
                return candidate
            }
        }
        return null
    }

    private fun findPrevNodes(num: Int): ArrayList<SkipNode?> {
        val prevs = ArrayList<SkipNode?>(head.nexts.size)
        repeat(head.nexts.size) { prevs.add(head) }
        var curr = head
        for (i in head.nexts.size - 1 downTo 0) {
            while (curr.nexts[i] != null && curr.nexts[i]!!.num < num) {
                curr = curr.nexts[i]!!
            }
            prevs[i] = curr
        }
        return prevs
    }

    private fun randomLevel(): Int {
        var level = 1
        while (random.nextInt(P_DENOMINATOR) + 1 <= P_NUMERATOR && level < MAX_LEVEL) {
            ++level
        }
        return level
    }

    companion object {
        private const val P_NUMERATOR = 1
        private const val P_DENOMINATOR = 2
        private const val MAX_LEVEL = 32
    }
}
