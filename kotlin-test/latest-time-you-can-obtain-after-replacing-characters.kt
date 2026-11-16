package latesttimeyoucanobtainafterreplacingcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LatestTimeYouCanObtainAfterReplacingCharactersTest {
    private val solution = Solution()

    @Test
    fun replacesAllWildcards() {
        assertEquals("11:59", solution.findLatestTime("??:??"))
    }

    @Test
    fun usesHourOnesToChooseHourTens() {
        assertEquals("04:39", solution.findLatestTime("?4:3?"))
    }

    @Test
    fun replacesHourOnesAndMinuteTens() {
        assertEquals("11:50", solution.findLatestTime("1?:?0"))
    }

    @Test
    fun keepsKnownDigits() {
        assertEquals("09:51", solution.findLatestTime("09:?1"))
    }

    @Test
    fun returnsCompleteTimeUnchanged() {
        assertEquals("00:00", solution.findLatestTime("00:00"))
    }
}
