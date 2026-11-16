package getwatchedvideosbyyourfriends

// Time:  O(n + vlogv), v is the number of the level videos
// Space: O(w)

class Solution {
    fun watchedVideosByFriends(watchedVideos: List<List<String>>, friends: Array<IntArray>, id: Int, level: Int): List<String> {
        var currentLevel = listOf(id)
        val lookup = hashSetOf(id)
        repeat(level) {
            val newLevel = mutableListOf<Int>()
            for (i in currentLevel) {
                for (j in friends[i]) {
                    if (!lookup.add(j)) {
                        continue
                    }
                    newLevel.add(j)
                }
            }
            currentLevel = newLevel
        }
        val count = HashMap<String, Int>()
        for (i in currentLevel) {
            for (video in watchedVideos[i]) {
                count[video] = (count[video] ?: 0) + 1
            }
        }
        return count.entries
            .sortedWith(compareBy<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
            .map { it.key }
    }
}
