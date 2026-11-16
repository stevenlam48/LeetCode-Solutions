package rewardtopkstudents
// Time:  O(pf * l + nf * l + n * l + klogk)
// Space: O(pf * l + nf * l + n)

import java.util.PriorityQueue

class Solution {
    fun topStudents(positiveFeedback: List<String>, negativeFeedback: List<String>, report: List<String>, studentId: IntArray, k: Int): IntArray {
        val positive = positiveFeedback.toHashSet()
        val negative = negativeFeedback.toHashSet()
        val order = compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        val top = PriorityQueue<Pair<Int, Int>>(order.reversed())
        for (i in report.indices) {
            var score = 0
            var left = 0
            for (right in report[i].indices) {
                if (right + 1 == report[i].length || report[i][right + 1] == ' ') {
                    val word = report[i].substring(left, right + 1)
                    score += if (word in positive) 3 else if (word in negative) -1 else 0
                    left = right + 2
                }
            }
            val entry = -score to studentId[i]
            if (k <= 0) continue
            if (top.size < k) {
                top.add(entry)
            } else if (order.compare(entry, top.peek()) < 0) {
                top.poll()
                top.add(entry)
            }
        }
        val result = top.toList().sortedWith(order)
        return IntArray(result.size) { result[it].second }
    }
}
