package countofsubstringscontainingeveryvowelandkconsonantsi

// Time:  O(n)
// Space: O(1)

// two pointers, sliding window, freq table
class Solution {
    fun countOfSubstrings(word: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        val cnt1 = IntArray(26)
        val cnt2 = IntArray(26)
        var curr1 = 0
        var curr2 = 0
        fun update(i: Int, d: Int) {
            if (word[i] !in vowels) {
                curr2 += d
                return
            }
            val x = word[i] - 'a'
            if (cnt1[x] == 0) {
                ++curr1
            }
            cnt1[x] += d
            if (cnt1[x] == 0) {
                --curr1
            }
        }

        var result = 0L
        var left = 0
        var mid = 0
        for (right in word.indices) {
            update(right, 1)
            while (curr2 > k) {
                update(left, -1)
                if (left < mid) {
                    --cnt2[word[left] - 'a']
                }
                ++left
                mid = maxOf(mid, left)
            }
            if (!(curr1 == vowels.size && curr2 == k)) {
                continue
            }
            while (mid < word.length && word[mid] in vowels &&
                cnt1[word[mid] - 'a'] - (cnt2[word[mid] - 'a'] + 1) >= 1
            ) {
                ++cnt2[word[mid] - 'a']
                ++mid
            }
            result += mid - left + 1
        }
        return result.toInt()
    }
}
