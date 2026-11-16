package numberofstringswhichcanberearrangedtocontainsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStringsWhichCanBeRearrangedToContainSubstringTest {
    private val solution = Solution()

    @Test
    fun tooShort() {
        assertEquals(0, solution.stringCount(1))
        assertEquals(0, solution.stringCount(3))
    }

    @Test
    fun minimumLength() {
        assertEquals(12, solution.stringCount(4))
    }

    @Test
    fun lengthFive() {
        assertEquals(1460, solution.stringCount(5))
    }

    @Test
    fun lengthSix() {
        assertEquals(106620, solution.stringCount(6))
    }
}
