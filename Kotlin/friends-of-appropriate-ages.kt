package friendsofappropriateages

// Time:  O(a^2 + n), a is the number of ages,
//                    n is the number of people
// Space: O(a)

class Solution {
    fun numFriendRequests(ages: IntArray): Int {
        val count = HashMap<Int, Int>()
        for (age in ages) {
            count[age] = (count[age] ?: 0) + 1
        }
        var result = 0
        for ((a, ca) in count) {
            for ((b, cb) in count) {
                if (request(a, b)) {
                    result += ca * (cb - if (a == b) 1 else 0)
                }
            }
        }
        return result
    }

    private fun request(a: Int, b: Int): Boolean {
        return 0.5 * a + 7 < b && b <= a
    }
}
