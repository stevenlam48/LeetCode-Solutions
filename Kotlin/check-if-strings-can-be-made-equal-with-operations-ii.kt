package checkifstringscanbemadeequalwithoperationsii

// Time:  O(1)
// Space: O(1)
class Solution {
    fun checkStrings(s1: String, s2: String): Boolean {
        val cnt1 = Array(2) { IntArray(26) }
        val cnt2 = Array(2) { IntArray(26) }
        for (i in 0 until 2) {
            for (j in i until s1.length step 2) {
                ++cnt1[i][s1[j] - 'a']
            }
            for (j in i until s1.length step 2) {
                ++cnt2[i][s2[j] - 'a']
            }
        }
        return cnt1.contentDeepEquals(cnt2)
    }
}
