package longestabsolutefilepath

// Time:  O(n)
// Space: O(d), d is the max depth of the paths

class Solution {
    fun lengthLongestPath(input: String): Int {
        val text = input + "\n"

        var maxLen = 0
        val pathLen = HashMap<Int, Int>()
        pathLen[0] = 0

        var prevI = 0
        var i = text.indexOf('\n')
        while (i != -1) {
            val line = text.substring(prevI, i)
            val name = line.trimStart('\t')
            val depth = line.length - name.length

            if (name.contains('.')) {
                maxLen = maxOf(maxLen, (pathLen[depth] ?: 0) + name.length)
            } else {
                pathLen[depth + 1] = (pathLen[depth] ?: 0) + name.length + 1
            }

            prevI = i + 1
            i = text.indexOf('\n', i + 1)
        }
        return maxLen
    }
}
