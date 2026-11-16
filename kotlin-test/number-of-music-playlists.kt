package numberofmusicplaylists

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfMusicPlaylistsTest {
    @Test
    fun standardExampleWithCooldown() {
        val solution = Solution()
        assertEquals(6, solution.numMusicPlaylists(3, 3, 1))
    }

    @Test
    fun standardExampleWithoutCooldown() {
        val solution = Solution()
        assertEquals(6, solution.numMusicPlaylists(2, 3, 0))
    }

    @Test
    fun longerPlaylist() {
        val solution = Solution()
        assertEquals(42, solution.numMusicPlaylists(3, 5, 1))
    }

    @Test
    fun cooldownPreventsExtensions() {
        val solution = Solution()
        assertEquals(0, solution.numMusicPlaylists(1, 2, 1))
    }
}
