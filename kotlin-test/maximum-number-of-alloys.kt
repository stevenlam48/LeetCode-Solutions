package maximumnumberofalloys

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfAlloysTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            2,
            solution.maxNumberOfAlloys(
                3,
                2,
                15,
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 10)),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            5,
            solution.maxNumberOfAlloys(
                3,
                2,
                15,
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 10)),
                intArrayOf(0, 0, 100),
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun exampleThree() {
        assertEquals(
            2,
            solution.maxNumberOfAlloys(
                2,
                3,
                10,
                arrayOf(intArrayOf(2, 1), intArrayOf(1, 2), intArrayOf(1, 1)),
                intArrayOf(1, 1),
                intArrayOf(5, 5)
            )
        )
    }

    @Test
    fun zeroBudget() {
        assertEquals(
            1,
            solution.maxNumberOfAlloys(
                1,
                1,
                0,
                arrayOf(intArrayOf(1)),
                intArrayOf(1),
                intArrayOf(1)
            )
        )
    }

    @Test
    fun noStockNoBudget() {
        assertEquals(
            0,
            solution.maxNumberOfAlloys(
                1,
                1,
                0,
                arrayOf(intArrayOf(1)),
                intArrayOf(0),
                intArrayOf(1)
            )
        )
    }
}
