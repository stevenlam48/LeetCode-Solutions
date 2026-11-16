package maximumnumberofweeksforwhichyoucanwork

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfWeeks(milestones: IntArray): Long {
        val total = milestones.sumOf { it.toLong() }
        val maxNum = milestones.max().toLong()
        val otherTotal = total - maxNum
        return otherTotal + minOf(otherTotal + 1, maxNum)
    }
}
