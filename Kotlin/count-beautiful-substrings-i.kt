package countbeautifulsubstringsi

// Time:  O(n + sqrt(k))
// Space: O(n)

class Solution {
    fun beautifulSubstrings(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val prefix = IntArray(s.length + 1)
        for (i in s.indices) {
            prefix[i + 1] = prefix[i] + if (s[i] in vowels) 1 else -1
        }
        var newK = 1
        var x = k
        var i = 2
        while (i * i <= k) {
            var cnt = 0
            while (x % i == 0) {
                x /= i
                ++cnt
            }
            if (cnt != 0) {
                repeat((cnt + 1) / 2 + if (i == 2) 1 else 0) {
                    newK *= i
                }
            }
            ++i
        }
        if (x != 1) {
            repeat(1 + if (x == 2) 1 else 0) {
                newK *= x
            }
        }
        val cnt = HashMap<Int, HashMap<Int, Int>>()
        var result = 0
        for (i in prefix.indices) {
            val counts = cnt.getOrPut(prefix[i]) { HashMap() }
            val modulo = i % newK
            result += counts[modulo] ?: 0
            counts[modulo] = (counts[modulo] ?: 0) + 1
        }
        return result
    }
}
