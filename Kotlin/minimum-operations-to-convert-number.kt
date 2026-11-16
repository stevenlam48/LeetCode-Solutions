package minimumoperationstoconvertnumber

// Time:  O(n * m), m is max x
// Space: O(m)

class Solution {
    fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
        val MAX_X = 1000

        val newNums = mutableListOf<Int>()
        for (y in nums) {
            if (y != 0 && (y in 0..MAX_X || goal - y in 0..MAX_X ||
                        goal + y in 0..MAX_X || (goal xor y) in 0..MAX_X)) {
                newNums.add(y)
            }
        }
        var q = mutableListOf(intArrayOf(start, 0))
        val lookup = HashSet<Int>()
        lookup.add(start)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (p in q) {
                val x = p[0]
                val steps = p[1]
                for (y in newNums) {
                    for (nx in intArrayOf(x + y, x - y, x xor y)) {
                        if (nx == goal) {
                            return steps + 1
                        }
                        if (nx !in 0..MAX_X || nx in lookup) {
                            continue
                        }
                        lookup.add(nx)
                        newQ.add(intArrayOf(nx, steps + 1))
                    }
                }
            }
            q = newQ
        }
        return -1
    }
}
