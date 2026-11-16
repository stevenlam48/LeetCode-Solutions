package countwordsobtainedafteraddingaletter

// Time:  O(n)
// Space: O(n)

class Solution {
    fun wordCount(startWords: List<String>, targetWords: List<String>): Int {
        fun bitmask(w: String): Int {
            var mask = 0
            for (c in w) {
                mask = mask or (1 shl (c - 'a'))
            }
            return mask
        }

        val lookup = HashSet<Int>()
        for (w in startWords) {
            lookup.add(bitmask(w))
        }
        var result = 0
        for (w in targetWords) {
            val mask = bitmask(w)
            for (c in w) {
                if (lookup.contains(mask xor (1 shl (c - 'a')))) {
                    ++result
                    break
                }
            }
        }
        return result
    }
}
