package alertusingsamekeycardthreeormoretimesinaonehourperiod

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriodTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(
            listOf("daniel"),
            solution.alertNames(
                listOf("daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"),
                listOf("10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00")
            )
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf("bob"),
            solution.alertNames(
                listOf("alice", "alice", "alice", "bob", "bob", "bob", "bob"),
                listOf("12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00")
            )
        )
    }

    @Test
    fun windowDoesNotCrossMidnight() {
        assertEquals(
            emptyList<String>(),
            solution.alertNames(listOf("john", "john", "john"), listOf("23:58", "23:59", "00:00"))
        )
    }

    @Test
    fun resultIsSortedAndBoundaryIsInclusive() {
        assertEquals(
            listOf("clare", "leslie"),
            solution.alertNames(
                listOf("leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"),
                listOf("13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49")
            )
        )
    }
}
