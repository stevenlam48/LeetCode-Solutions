package lexicographicallysmallestpalindromicpermutationgreaterthantarget

// Time:  O(26 * n)
// Space: O(26)

class Solution {
    fun lexPalindromicPermutation(s: String, target: String): String {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        var c = 0
        for (i in cnt.indices) {
            c += cnt[i] % 2
        }
        if (c > 1) {
            return ""
        }
        var x = -1
        if (s.length % 2 == 1) {
            for (i in cnt.indices) {
                if (cnt[i] % 2 == 1) {
                    x = i
                    --cnt[i]
                    break
                }
            }
        }
        val result = StringBuilder()
        var i = 0
        while (i < target.length / 2) {
            cnt[target[i] - 'a'] -= 2
            result.append(target[i])
            if (cnt[target[i] - 'a'] < 0) {
                break
            }
            ++i
        }
        if (i == target.length / 2) {
            if (target.length % 2 == 1) {
                result.append('a' + x)
            }
            val ret = result.toString() + result.reversed().substring(target.length % 2)
            if (ret > target) {
                return ret
            }
            if (target.length % 2 == 1) {
                result.deleteCharAt(result.length - 1)
            }
        }
        while (result.isNotEmpty()) {
            val ci = result[result.length - 1] - 'a'
            result.deleteCharAt(result.length - 1)
            cnt[ci] += 2
            for (j in ci + 1 until cnt.size) {
                if (cnt[j] == 0) {
                    continue
                }
                cnt[j] -= 2
                result.append('a' + j)
                for (k in cnt.indices) {
                    if (cnt[k] == 0) {
                        continue
                    }
                    while (cnt[k] != 0) {
                        cnt[k] -= 2
                        result.append('a' + k)
                    }
                }
                if (target.length % 2 == 1) {
                    result.append('a' + x)
                }
                return result.toString() + result.reversed().substring(target.length % 2)
            }
        }
        return ""
    }
}
