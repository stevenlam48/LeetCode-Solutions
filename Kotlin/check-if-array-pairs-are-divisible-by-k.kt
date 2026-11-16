package checkifarraypairsaredivisiblebyk

// Time:  O(n)
// Space: O(k)

class Solution {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val count = HashMap<Int, Int>()
        for (x in arr) {
            val r = (x % k + k) % k
            count[r] = (count[r] ?: 0) + 1
        }
        if (count.containsKey(0) && count[0]!! % 2 != 0) {
            return false
        }
        for (i in 1 until k) {
            if (!count.containsKey(i)) {
                continue
            }
            if (!(count.containsKey(k - i) && count[i] == count[k - i])) {
                return false
            }
        }
        return true
    }
}
