package minimumuniquewordabbreviation

// Time:  O((d + n) * 2^n)
// Space: O(d)

// optimized from Solution2
class Solution {
    fun minAbbreviation(target: String, dictionary: List<String>): String {
        val diffs = mutableListOf<Int>()
        dictionaryToDiffs(target, dictionary, diffs)
        if (diffs.isEmpty()) {
            return target.length.toString()
        }
        val total = 1 shl target.length
        var result = total - 1
        for (mask in 0 until total) {
            if (diffs.all { (it and mask) != 0 }) {
                if (bitsToAbbrLen(target, mask) < bitsToAbbrLen(target, result)) {
                    result = mask
                }
            }
        }
        return bitsToAbbr(target, result)
    }

    private fun dictionaryToDiffs(target: String, dictionary: List<String>, diffs: MutableList<Int>) {
        for (word in dictionary) {
            if (word.length != target.length) {
                continue
            }
            var bits = 0
            for (i in word.indices) {
                if (target[i] != word[i]) {
                    bits = bits or (1 shl i)
                }
            }
            diffs.add(bits)
        }
    }

    private fun bitsToAbbrLen(target: String, bitsIn: Int): Int {
        var bits = bitsIn
        var total = 0
        var pre = 0
        for (i in target.indices) {
            if (bits and 1 != 0) {
                if (i - pre > 0) {
                    total += (i - pre).toString().length
                }
                pre = i + 1
                ++total
            } else if (i == target.length - 1) {
                total += (i - pre + 1).toString().length
            }
            bits = bits shr 1
        }
        return total
    }

    private fun bitsToAbbr(target: String, bitsIn: Int): String {
        var bits = bitsIn
        val abbr = StringBuilder()
        var pre = 0
        for (i in target.indices) {
            if (bits and 1 != 0) {
                if (i - pre > 0) {
                    abbr.append(i - pre)
                }
                pre = i + 1
                abbr.append(target[i])
            } else if (i == target.length - 1) {
                abbr.append(i - pre + 1)
            }
            bits = bits shr 1
        }
        return abbr.toString()
    }
}
