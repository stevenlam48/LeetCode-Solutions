package restoreIpAddresses

// Time Complexity: O(n^m), where n is max length of number, m is count of segment
// Space Complexity: O(nm)

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val ans = ArrayList<String>()
        dfs(s, 0, 4, "", ans)
        return ans
    }

    private fun dfs(s: String, start: Int, step: Int, ip: String, ans: MutableList<String>) {
        if (start == s.length && step == 0) {
            ans.add(ip.dropLast(1))
            return
        }

        if (s.length - start < step || s.length - start > step * 3) {
            return
        }

        var num = 0
        var i = start
        val ip2 = StringBuilder(ip)
        while (i < start + 3) {
            if (i >= s.length) {
                break
            }
            num = num * 10 + (s[i] - '0')
            if (num > 255) {
                break
            }
            ip2.append(s[i])
            dfs(s, i + 1, step - 1, "$ip2.", ans)
            if (num == 0) {
                break
            }
            ++i
        }
    }
}
