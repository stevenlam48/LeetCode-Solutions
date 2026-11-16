package checkifstringistransformablewithsubstringsortoperations

// Time:  O(n)
// Space: O(n)
class Solution {
    fun isTransformable(s: String, t: String): Boolean {
        val idxs = Array(10) { ArrayList<Int>() }
        for (i in s.length - 1 downTo 0) {
            idxs[s[i] - '0'].add(i)
        }
        for (c in t) {
            val d = c - '0'
            if (idxs[d].isEmpty()) {
                return false
            }
            for (i in 0 until d) {
                if (idxs[i].isNotEmpty() && idxs[i].last() < idxs[d].last()) {
                    return false
                }
            }
            idxs[d].removeAt(idxs[d].lastIndex)
        }
        return true
    }
}
