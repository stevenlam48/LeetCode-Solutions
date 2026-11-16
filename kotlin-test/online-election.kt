package onlineelection

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OnlineElectionTest {
    @Test
    fun testExample() {
        val candidate = TopVotedCandidate(
            intArrayOf(0, 1, 1, 0, 0, 1, 0),
            intArrayOf(0, 5, 10, 15, 20, 25, 30)
        )
        assertEquals(0, candidate.q(3))
        assertEquals(1, candidate.q(12))
        assertEquals(1, candidate.q(25))
        assertEquals(0, candidate.q(15))
        assertEquals(0, candidate.q(24))
        assertEquals(1, candidate.q(8))
    }

    @Test
    fun testSinglePerson() {
        val candidate = TopVotedCandidate(intArrayOf(2), intArrayOf(7))
        assertEquals(2, candidate.q(7))
        assertEquals(2, candidate.q(100))
    }

    @Test
    fun testTieGoesToLatest() {
        val candidate = TopVotedCandidate(
            intArrayOf(1, 2, 1, 2),
            intArrayOf(1, 2, 3, 4)
        )
        assertEquals(1, candidate.q(1))
        assertEquals(2, candidate.q(2))
        assertEquals(1, candidate.q(3))
        assertEquals(2, candidate.q(4))
    }
}
