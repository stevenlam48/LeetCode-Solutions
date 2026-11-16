package splitastringintothemaxnumberofuniquesubstrings

// Time:  O(n * 2^(n - 1))
// Space: O(n)

class Solution {
    fun maxUniqueSplit(s: String): Int {
        var result = 1
        val total = 1 shl (s.length - 1)
        var mask = 0
        while (mask < total) {
            if (Integer.bitCount(mask) < result) {
                ++mask
                continue
            }
            val lookup = HashSet<String>()
            val curr = StringBuilder()
            var unique = true
            var i = 0
            var base = total / 2
            while (i < s.length) {
                curr.append(s[i])
                if ((mask and base) != 0 || base == 0) {
                    if (!lookup.add(curr.toString())) {
                        unique = false
                        mask = if (base != 0) (mask or (base - 1)) + 1 else mask + 1
                        break
                    }
                    curr.setLength(0)
                }
                ++i
                base = base shr 1
            }
            if (!unique) {
                continue
            }
            result = maxOf(result, lookup.size)
            ++mask
        }
        return result
    }
}
