package zumagame

// Time:  O((b+h)^2 * h!*(b+h-1)!/(b-1)!)
// Space: O((b+h) * h!*(b+h-1)!/(b-1)!)

// brute force solution with worse complexity but pass
class Solution {
    fun findMinStep(board: String, hand: String): Int {
        val lookup = HashMap<String, HashMap<String, Int>>()
        val result = findMinStepHelper(board, hand, lookup)
        return if (result > hand.length) -1 else result
    }

    private fun findMinStepHelper(
        board: String,
        hand: String,
        lookup: HashMap<String, HashMap<String, Int>>,
    ): Int {
        if (board.isEmpty()) {
            return 0
        }
        if (hand.isEmpty()) {
            return MAX_STEP
        }
        val cached = lookup[board]?.get(hand)
        if (cached != null && cached != 0) {
            return cached
        }

        var result = MAX_STEP
        for (i in hand.indices) {
            for (j in 0..board.length) {
                val nextBoard = shrink(board.substring(0, j) + hand[i] + board.substring(j))
                val nextHand = hand.substring(0, i) + hand.substring(i + 1)
                result = minOf(result, findMinStepHelper(nextBoard, nextHand, lookup) + 1)
            }
        }
        lookup.getOrPut(board) { HashMap() }[hand] = result
        return result
    }

    private fun shrink(s: String): String {
        var cur = s
        var changed = true
        while (changed) {
            changed = false
            var i = 0
            var start = 0
            while (start < cur.length) {
                while (i < cur.length && cur[start] == cur[i]) {
                    ++i
                }
                if (i - start >= 3) {
                    cur = cur.substring(0, start) + cur.substring(i)
                    changed = true
                    break
                }
                ++start
            }
        }
        return cur
    }

    private companion object {
        const val MAX_STEP = 6
    }
}
