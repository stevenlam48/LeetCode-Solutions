package rabbitsinforest

// Time:  O(n)
// Space: O(n)

class Solution {
    fun numRabbits(answers: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        for (answer in answers) {
            lookup[answer] = (lookup[answer] ?: 0) + 1
        }
        var result = 0
        for ((key, value) in lookup) {
            result += ((key + 1) + value - 1) / (key + 1) * (key + 1)
        }
        return result
    }
}
