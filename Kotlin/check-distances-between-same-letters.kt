package checkdistancesbetweensameletters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkDistances(s: String, distance: IntArray): Boolean {
        for (i in s.indices) {
            val index = s[i].code - 'a'.code
            if (i + distance[index] + 1 >= s.length || s[i + distance[index] + 1] != s[i]) {
                return false
            }
            distance[index] = -1
        }
        return true
    }
}
