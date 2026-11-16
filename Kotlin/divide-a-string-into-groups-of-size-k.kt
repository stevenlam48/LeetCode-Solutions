package divideastringintogroupsofsizek
// Time:  O(n)
// Space: O(1)

class Solution {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val result = Array((s.length + k - 1) / k) { fill.toString().repeat(k) }
        for (i in s.indices) {
            val index = i / k
            val position = i % k
            result[index] = result[index].replaceRange(position, position + 1, s[i].toString())
        }
        return result
    }
}
