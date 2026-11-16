package maximumnumberofeventsthatcanbeattendedii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfEventsThatCanBeAttendedIITest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            7,
            solution.maxValue(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(3, 4, 3),
                    intArrayOf(2, 3, 1)
                ),
                2
            )
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            10,
            solution.maxValue(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(3, 4, 3),
                    intArrayOf(2, 3, 10)
                ),
                2
            )
        )
    }

    @Test
    fun exampleThree() {
        assertEquals(
            9,
            solution.maxValue(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(2, 2, 2),
                    intArrayOf(3, 3, 3),
                    intArrayOf(4, 4, 4)
                ),
                3
            )
        )
    }

    @Test
    fun singleEvent() {
        assertEquals(4, solution.maxValue(arrayOf(intArrayOf(1, 2, 4)), 1))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(
            4,
            solution.maxValue(
                arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 4, 3)),
                1
            )
        )
    }

    @Test
    fun twoNonOverlapping() {
        assertEquals(
            7,
            solution.maxValue(
                arrayOf(intArrayOf(1, 2, 4), intArrayOf(3, 4, 3)),
                2
            )
        )
    }
}
