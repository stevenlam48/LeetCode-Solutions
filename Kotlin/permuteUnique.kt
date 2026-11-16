package permuteUnique
// Time Complexity: O(n!)
// Space Complexity: O(n)

class Solution {
    private var n = 0

    fun permuteUnique(num: IntArray): List<List<Int>> {
        num.sort()
        val countMap = HashMap<Int, Int>()
        for (e in num) {
            countMap[e] = (countMap[e] ?: 0) + 1
        }
        val ans = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        n = num.size
        permute(countMap, path, ans)
        return ans
    }

    private fun permute(
        countMap: HashMap<Int, Int>,
        path: MutableList<Int>,
        ans: MutableList<List<Int>>
    ) {
        if (n == path.size) {
            ans.add(path.toList())
        }
        for ((key, count) in countMap) {
            if (count != 0) {
                path.add(key)
                countMap[key] = count - 1
                permute(countMap, path, ans)
                path.removeAt(path.lastIndex)
                countMap[key] = count
            }
        }
    }
}
