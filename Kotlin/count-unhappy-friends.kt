package countunhappyfriends

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
        val friends = Array(n) { IntArray(n) }
        for (i in preferences.indices) {
            for (j in preferences[i].indices) {
                friends[i][preferences[i][j]] = j
            }
        }
        val pairing = IntArray(n)
        for (p in pairs) {
            pairing[p[0]] = p[1]
            pairing[p[1]] = p[0]
        }

        var result = 0
        for (i in friends.indices) {
            for (j in friends[i].indices) {
                if (j == i || j == pairing[i]) {
                    continue
                }
                if (friends[i][j] < friends[i][pairing[i]] &&
                    friends[j][i] < friends[j][pairing[j]]
                ) {
                    ++result
                    break
                }
            }
        }
        return result
    }
}
