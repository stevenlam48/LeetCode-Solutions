package designaleaderboard

// Time:  ctor:  O(1)
//        add:   O(1)
//        top:   O(n)
//        reset: O(1)
// Space: O(n)

class Leaderboard {
    private val lookup = HashMap<Int, Int>()

    fun addScore(playerId: Int, score: Int) {
        lookup[playerId] = (lookup[playerId] ?: 0) + score
    }

    fun top(K: Int): Int {
        return lookup.values.sortedDescending().take(K).sum()
    }

    fun reset(playerId: Int) {
        lookup[playerId] = 0
    }
}
