package findtheoriginalarrayofprefixxor

// Time:  O(n)
// Space: O(1)
class Solution {
    fun findArray(pref: IntArray): IntArray {
        for (i in pref.lastIndex downTo 1) {
            pref[i] = pref[i] xor pref[i - 1]
        }
        return pref
    }
}
