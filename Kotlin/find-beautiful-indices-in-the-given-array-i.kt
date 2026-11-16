package findbeautifulindicesinthegivenarrayi

// Time:  O(n), x = len(KMP(s, a)), y = len(KMP(s, b))
// Space: O(min(a + b + x + y, n))

class Solution {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        val result = ArrayList<Int>()
        if (a.length > s.length || b.length > s.length) {
            return result
        }
        val lookup = kmp(s, b)
        var j = 0
        for (i in kmp(s, a)) {
            while (j < lookup.size && lookup[j] < i - k) {
                ++j
            }
            if (j < lookup.size && lookup[j] <= i + k) {
                result.add(i)
            }
        }
        return result
    }

    private fun kmp(text: String, pattern: String): List<Int> {
        val prefix = IntArray(pattern.length) { -1 }
        var matched = -1
        for (i in 1 until pattern.length) {
            while (matched > -1 && pattern[matched + 1] != pattern[i]) {
                matched = prefix[matched]
            }
            if (pattern[matched + 1] == pattern[i]) {
                ++matched
            }
            prefix[i] = matched
        }
        val result = ArrayList<Int>()
        matched = -1
        for (i in text.indices) {
            while (matched > -1 && pattern[matched + 1] != text[i]) {
                matched = prefix[matched]
            }
            if (pattern[matched + 1] == text[i]) {
                ++matched
            }
            if (matched == pattern.length - 1) {
                result.add(i - matched)
                matched = prefix[matched]
            }
        }
        return result
    }
}
