package numberofuniqueflavorsaftersharingkcandies

// Time:  O(n)
// Space: O(n)

class Solution {
    fun shareCandies(candies: IntArray, k: Int): Int {
        val cnt = HashMap<Int, Int>()
        for (i in k until candies.size) {
            cnt[candies[i]] = (cnt[candies[i]] ?: 0) + 1
        }
        var curr = cnt.size
        var result = curr
        for (i in k until candies.size) {
            val add = if ((cnt[candies[i - k]] ?: 0) == 0) 1 else 0
            cnt[candies[i - k]] = (cnt[candies[i - k]] ?: 0) + 1
            val old = cnt[candies[i]] ?: 0
            cnt[candies[i]] = old - 1
            val sub = if (old - 1 == 0) 1 else 0
            curr += add - sub
            result = maxOf(result, curr)
        }
        return result
    }
}
