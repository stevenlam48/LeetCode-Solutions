package maximumnumberofeventsthatcanbeattended

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfEventsThatCanBeAttendedTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            3,
            solution.maxEvents(
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
            )
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            4,
            solution.maxEvents(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 2)
                )
            )
        )
    }

    @Test
    fun overlappingStarts() {
        assertEquals(
            7,
            solution.maxEvents(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(1, 6),
                    intArrayOf(1, 7)
                )
            )
        )
    }

    @Test
    fun identicalEvents() {
        assertEquals(
            1,
            solution.maxEvents(
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1))
            )
        )
    }

    @Test
    fun longEventCoversOthers() {
        assertEquals(
            2,
            solution.maxEvents(
                arrayOf(intArrayOf(1, 10), intArrayOf(2, 2), intArrayOf(2, 2))
            )
        )
    }
}
