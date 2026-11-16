package minimumnumberofchairsinawaitingroom

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumNumberOfChairsInAWaitingRoomTest {
    @Test
    fun allEntriesRequireOneChairPerPerson() {
        assertEquals(7, Solution().minimumChairs("EEEEEEE"))
    }

    @Test
    fun alternatingEntriesAndExitsReuseChairs() {
        assertEquals(2, Solution().minimumChairs("ELELEEL"))
    }

    @Test
    fun laterPeakDeterminesMinimum() {
        assertEquals(3, Solution().minimumChairs("ELEELEELLL"))
    }

    @Test
    fun emptyRoomNeedsNoChairs() {
        assertEquals(0, Solution().minimumChairs(""))
    }
}
