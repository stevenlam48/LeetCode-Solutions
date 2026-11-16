package exclusivetimeoffunctions

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ExclusiveTimeOfFunctionsTest {
    @Test
    fun nestedFunctionsExample() {
        val logs = listOf("0:start:0", "1:start:2", "1:end:5", "0:end:6")
        assertArrayEquals(intArrayOf(3, 4), Solution().exclusiveTime(2, logs))
    }

    @Test
    fun repeatedSingleFunctionExample() {
        val logs = listOf(
            "0:start:0", "0:start:2", "0:end:5",
            "0:start:6", "0:end:6", "0:end:7"
        )
        assertArrayEquals(intArrayOf(8), Solution().exclusiveTime(1, logs))
    }

    @Test
    fun backToBackFunctions() {
        val logs = listOf("0:start:0", "0:end:0", "1:start:1", "1:end:1")
        assertArrayEquals(intArrayOf(1, 1), Solution().exclusiveTime(2, logs))
    }

    @Test
    fun threeLevelNesting() {
        val logs = listOf(
            "0:start:0", "1:start:1", "2:start:2",
            "2:end:2", "1:end:3", "0:end:4"
        )
        assertArrayEquals(intArrayOf(2, 2, 1), Solution().exclusiveTime(3, logs))
    }
}
