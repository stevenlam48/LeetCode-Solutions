package dota2senate

// Time:  O(n)
// Space: O(n)

class Solution {
    fun predictPartyVictory(senate: String): String {
        val radiant = java.util.ArrayDeque<Int>()
        val dire = java.util.ArrayDeque<Int>()
        val n = senate.length
        for (i in 0 until n) {
            if (senate[i] == 'R') radiant.addLast(i) else dire.addLast(i)
        }
        while (radiant.isNotEmpty() && dire.isNotEmpty()) {
            val rIdx = radiant.removeFirst()
            val dIdx = dire.removeFirst()
            if (rIdx < dIdx) radiant.addLast(rIdx + n) else dire.addLast(dIdx + n)
        }
        return if (radiant.size > dire.size) "Radiant" else "Dire"
    }
}
