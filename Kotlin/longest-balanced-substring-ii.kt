package longestbalancedsubstringii

// Time:  O(n)
// Space: O(n)

// hash table, prefix sum
class Solution {
    fun longestBalanced(s: String): Int {
        fun count1(): Int {
            var result = 0
            var cnt = 0
            for (i in s.indices) {
                ++cnt
                if (i + 1 == s.length || s[i + 1] != s[i]) {
                    result = maxOf(result, cnt)
                    cnt = 0
                }
            }
            return result
        }

        fun count2(a: Char, b: Char): Int {
            var result = 0
            var cnt = 0
            var lookup = HashMap<Int, Int>()
            lookup[cnt] = -1
            for (i in s.indices) {
                if (s[i] == a) {
                    ++cnt
                } else if (s[i] == b) {
                    --cnt
                } else {
                    cnt = 0
                    lookup = HashMap()
                    lookup[cnt] = i
                    continue
                }
                val seen = lookup[cnt]
                if (seen != null) {
                    result = maxOf(result, i - seen)
                } else {
                    lookup[cnt] = i
                }
            }
            return result
        }

        fun count3(): Int {
            var result = 0
            var a = 0
            var b = 0
            val lookup = HashMap<Pair<Int, Int>, Int>()
            lookup[a to b] = -1
            for (i in s.indices) {
                if (s[i] == 'a') {
                    ++a
                } else if (s[i] == 'b') {
                    ++b
                } else {
                    --a
                    --b
                }
                val key = a to b
                val seen = lookup[key]
                if (seen != null) {
                    result = maxOf(result, i - seen)
                } else {
                    lookup[key] = i
                }
            }
            return result
        }

        return maxOf(count1(), count2('a', 'b'), count2('b', 'c'), count2('c', 'a'), count3())
    }
}
