package handshakesthatdontcross

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HandshakesThatDontCrossTest {
    @Test
    fun twoPeople() {
        assertEquals(1, Solution().numberOfWays(2))
    }

    @Test
    fun fourPeople() {
        assertEquals(2, Solution().numberOfWays(4))
    }

    @Test
    fun sixPeople() {
        assertEquals(5, Solution().numberOfWays(6))
    }

    @Test
    fun eightPeople() {
        assertEquals(14, Solution().numberOfWays(8))
    }

    @Test
    fun tenPeople() {
        assertEquals(42, Solution().numberOfWays(10))
    }

    @Test
    fun twentyPeople() {
        assertEquals(16796, Solution().numberOfWays(20))
    }
}
