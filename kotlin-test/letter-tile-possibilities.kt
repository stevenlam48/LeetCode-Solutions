package lettertilepossibilities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LetterTilePossibilitiesTest {
    @Test
    fun example1() {
        assertEquals(8, Solution().numTilePossibilities("AAB"))
    }

    @Test
    fun example2() {
        assertEquals(188, Solution().numTilePossibilities("AAABBC"))
    }

    @Test
    fun singleTile() {
        assertEquals(1, Solution().numTilePossibilities("V"))
    }

    @Test
    fun distinctTiles() {
        assertEquals(15, Solution().numTilePossibilities("ABC"))
    }
}
