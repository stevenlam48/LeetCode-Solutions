package lexicographicallysmallestpermutationgreaterthantarget

// Time:  O(26 * n)
// Space: O(26)

class Solution {
    fun lexGreaterPermutation(s: String, target: String): String {
        val nxt = { cnt: IntArray, x: Char ->
            var found = -1
            for (i in (x - 'a') + 1 until cnt.size) {
                if (cnt[i] == 0) {
                    continue
                }
                found = i
                break
            }
            if (found == -1) ' ' else 'a' + found
        }

        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        val tmp = cnt.copyOf()
        var j = -1
        for (i in target.indices) {
            val y = nxt(tmp, target[i])
            if (y != ' ') {
                j = i
            }
            if (tmp[target[i] - 'a'] == 0) {
                break
            }
            --tmp[target[i] - 'a']
        }
        val result = StringBuilder()
        if (j == -1) {
            return result.toString()
        }
        for (i in 0 until j) {
            result.append(target[i])
            --cnt[target[i] - 'a']
        }
        val y = nxt(cnt, target[j])
        result.append(y)
        --cnt[y - 'a']
        for (i in cnt.indices) {
            while (cnt[i] != 0) {
                result.append('a' + i)
                --cnt[i]
            }
        }
        return result.toString()
    }
}
