package highaccessemployees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HighAccessEmployeesTest {
    @Test
    fun standardExample() {
        val accessTimes = listOf(
            listOf("a", "0549"),
            listOf("b", "0457"),
            listOf("a", "0532"),
            listOf("a", "0621"),
            listOf("b", "0540")
        )

        assertEquals(setOf("a"), Solution().findHighAccessEmployees(accessTimes).toSet())
    }

    @Test
    fun periodShorterThanSixtyMinutesNotLessThanOrEqual() {
        val accessTimes = listOf(
            listOf("a", "0000"),
            listOf("a", "0030"),
            listOf("a", "0100")
        )

        assertEquals(emptySet<String>(), Solution().findHighAccessEmployees(accessTimes).toSet())
    }

    @Test
    fun unorderedTimesAndMultipleEmployees() {
        val accessTimes = listOf(
            listOf("beta", "1200"),
            listOf("alpha", "0000"),
            listOf("beta", "1159"),
            listOf("gamma", "0100"),
            listOf("beta", "1201"),
            listOf("alpha", "0200"),
            listOf("gamma", "0000"),
            listOf("gamma", "0059")
        )

        assertEquals(setOf("beta"), Solution().findHighAccessEmployees(accessTimes).toSet())
    }

    @Test
    fun duplicateTimestampsCountAsSeparateAccesses() {
        val accessTimes = listOf(
            listOf("a", "0800"),
            listOf("a", "0800"),
            listOf("a", "0800")
        )

        assertEquals(setOf("a"), Solution().findHighAccessEmployees(accessTimes).toSet())
    }

    @Test
    fun emptyOrFewerThanThreeAccesses() {
        assertEquals(emptySet<String>(), Solution().findHighAccessEmployees(emptyList()).toSet())
        assertEquals(
            emptySet<String>(),
            Solution().findHighAccessEmployees(listOf(listOf("a", "0000"), listOf("a", "0001"))).toSet()
        )
    }
}
