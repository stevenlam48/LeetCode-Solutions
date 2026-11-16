package checkarrayformationthroughconcatenation

// Time:  O(n)
// Space: O(n)

class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val lookup = HashMap<Int, Int>()
        for (i in pieces.indices) {
            lookup[pieces[i][0]] = i
        }
        var i = 0
        while (i < arr.size) {
            val pieceIndex = lookup[arr[i]] ?: return false
            for (c in pieces[pieceIndex]) {
                if (i == arr.size || arr[i] != c) {
                    return false
                }
                ++i
            }
        }
        return true
    }
}
