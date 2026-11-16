package groupanagrams

// Time:  O(n * glogg), g is the max size of groups.
// Space: O(n)

class Solution {
    fun groupAnagrams(strs: List<String>): List<List<String>> {
        val groups = HashMap<String, MutableList<String>>()
        for (str in strs) {
            val tmp = str.toCharArray()
            tmp.sort()
            groups.getOrPut(String(tmp)) { ArrayList() }.add(str)
        }

        val anagrams = ArrayList<List<String>>()
        for (group in groups.values) {
            group.sort()
            anagrams.add(group)
        }

        return anagrams
    }
}
