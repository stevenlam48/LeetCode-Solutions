package stringtransformsintoanotherstring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun canConvert(str1: String, str2: String): Boolean {
        if (str1 == str2) {
            return true
        }
        val lookup = HashMap<Char, Char>()
        for (i in str1.indices) {
            lookup.putIfAbsent(str1[i], str2[i])
            if (lookup[str1[i]] != str2[i]) {
                return false
            }
        }
        return str2.toHashSet().size < 26
    }
}
