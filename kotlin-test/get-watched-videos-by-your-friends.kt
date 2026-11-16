package getwatchedvideosbyyourfriends

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetWatchedVideosByYourFriendsTest {
    private val watchedVideos = listOf(
        listOf("A", "B"),
        listOf("C"),
        listOf("B", "C"),
        listOf("D")
    )
    private val friends = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(0, 3),
        intArrayOf(0, 3),
        intArrayOf(1, 2)
    )

    @Test
    fun `level one sorts by frequency then title`() {
        assertEquals(listOf("B", "C"), Solution().watchedVideosByFriends(watchedVideos, friends, 0, 1))
    }

    @Test
    fun `level two excludes nearer friends and source`() {
        assertEquals(listOf("D"), Solution().watchedVideosByFriends(watchedVideos, friends, 0, 2))
    }

    @Test
    fun `level zero uses source and unreachable level is empty`() {
        val solution = Solution()
        assertEquals(listOf("A", "B"), solution.watchedVideosByFriends(watchedVideos, friends, 0, 0))
        val isolatedFriends = arrayOf(intArrayOf(), intArrayOf())
        assertEquals(emptyList<String>(), solution.watchedVideosByFriends(watchedVideos, isolatedFriends, 0, 1))
    }
}
