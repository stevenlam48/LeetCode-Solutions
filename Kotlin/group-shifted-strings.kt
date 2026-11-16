package groupshiftedstrings

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun groupStrings(strings: List<String>): List<List<String>> {
        val groups = HashMap<String, java.util.TreeSet<String>>()
        for (str in strings) {
            groups.getOrPut(hashStr(str)) { java.util.TreeSet() }.add(str)
        }

        val result = ArrayList<List<String>>()
        for (group in groups.values) {
            result.add(group.toList())
        }

        return result
    }

    fun hashStr(str: String): String {
        val base = str[0]
        val chars = CharArray(str.length)
        for (i in str.indices) {
            val c = str[i]
            chars[i] = 'a' + ((c - base) + 26) % 26
        }
        return String(chars)
    }
}
