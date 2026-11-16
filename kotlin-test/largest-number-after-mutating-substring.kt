package largestnumberaftermutatingsubstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestNumberAfterMutatingSubstringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            "865",
            solution.maximumNumber("132", intArrayOf(9, 8, 5, 6, 7, 4, 3, 2, 1, 0))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            "958",
            solution.maximumNumber("021", intArrayOf(9, 8, 5, 6, 7, 4, 3, 2, 1, 0))
        )
    }

    @Test
    fun testNoMutation() {
        assertEquals(
            "123",
            solution.maximumNumber("123", intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        )
    }

    @Test
    fun testStopAfterMutation() {
        assertEquals(
            "923",
            solution.maximumNumber("123", intArrayOf(0, 9, 0, 0, 0, 0, 0, 0, 0, 0))
        )
    }

    @Test
    fun testEqualChangeContinues() {
        assertEquals(
            "123",
            solution.maximumNumber("123", intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
        )
    }
}
