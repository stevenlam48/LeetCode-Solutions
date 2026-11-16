package shortestpathtogetallkeys

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathToGetAllKeysTest {
    @Test
    fun collectsTwoKeys() {
        assertEquals(8, Solution().shortestPathAllKeys(listOf("@.a..", "###.#", "b.A.B")))
    }

    @Test
    fun collectsKeysBehindDoors() {
        assertEquals(6, Solution().shortestPathAllKeys(listOf("@..aA", "..B#.", "....b")))
    }

    @Test
    fun returnsMinusOneWhenKeyIsLockedBehindItsDoor() {
        assertEquals(-1, Solution().shortestPathAllKeys(listOf("@Aa")))
    }

    @Test
    fun collectsThreeKeys() {
        assertEquals(10, Solution().shortestPathAllKeys(listOf("@...a", ".###A", "b.BCc")))
    }

    @Test
    fun returnsZeroWhenNoKeysExist() {
        assertEquals(0, Solution().shortestPathAllKeys(listOf("@.")))
    }
}
