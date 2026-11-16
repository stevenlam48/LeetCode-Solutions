package sortvowelsbyfrequency

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortVowels(s: String): String {
        val counts = HashMap<Char, IntArray>()
        for (i in s.indices) {
            if (VOWELS.indexOf(s[i]) == -1) {
                continue
            }
            if (!counts.containsKey(s[i])) {
                counts[s[i]] = intArrayOf(0, i)
            }
            ++counts.getValue(s[i])[0]
        }
        val sortedCounts = counts.map { (c, value) -> VowelCount(c, value[0], value[1]) }
        val work = sortedCounts.toMutableList()
        work.sortWith(compareBy<VowelCount> { it.count }.thenByDescending { it.firstIndex })
        val result = s.toCharArray()
        for (i in result.indices) {
            if (VOWELS.indexOf(result[i]) == -1) {
                continue
            }
            val current = work.last()
            result[i] = current.char
            --current.count
            if (current.count == 0) {
                work.removeAt(work.lastIndex)
            }
        }
        return String(result)
    }

    private class VowelCount(val char: Char, var count: Int, val firstIndex: Int)

    companion object {
        private const val VOWELS = "aeiou"
    }
}
