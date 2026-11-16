package checkifnanditsdoubleexist

// Time:  O(n)
// Space: O(n)
class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val lookup = HashSet<Int>()
        for (x in arr) {
            if (lookup.contains(2 * x) || (x % 2 == 0 && lookup.contains(x / 2))) {
                return true
            }
            lookup.add(x)
        }
        return false
    }
}
