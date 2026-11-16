package buildanarraywithstackoperations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()
        var curr = 1
        for (t in target) {
            for (i in curr until t) {
                result.add("Push")
                result.add("Pop")
            }
            result.add("Push")
            curr = t + 1
        }
        return result
    }
}
