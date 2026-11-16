package sortcharactersbyfrequency

// Time:  O(n)
// Space: O(n)

class Solution {
    fun frequencySort(s: String): String {
        val freq = HashMap<Char, Int>()
        for (c in s) {
            freq[c] = freq.getOrDefault(c, 0) + 1
        }

        val counts = Array(s.length + 1) { StringBuilder() }
        for ((c, count) in freq) {
            counts[count].append(c)
        }

        val result = StringBuilder()
        for (count in counts.size - 1 downTo 0) {
            for (c in counts[count]) {
                result.append(c.toString().repeat(count))
            }
        }
        return result.toString()
    }
}
