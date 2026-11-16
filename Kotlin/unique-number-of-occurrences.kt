package uniquenumberofoccurrences

// Time:  O(n)
// Space: O(n)

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val count = HashMap<Int, Int>()
        for (a in arr) {
            count[a] = (count[a] ?: 0) + 1
        }
        val lookup = HashSet<Int>()
        for (value in count.values) {
            if (!lookup.add(value)) {
                return false
            }
        }
        return true
    }
}
