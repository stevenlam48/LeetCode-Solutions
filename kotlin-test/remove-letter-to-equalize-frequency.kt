package removelettertoequalizefrequency

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveLetterToEqualizeFrequencyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.equalFrequency("abcc"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.equalFrequency("aazz"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.equalFrequency("bac"))
    }

    @Test
    fun testRemoveSingleOccurrence() {
        assertTrue(solution.equalFrequency("abbcc"))
    }

    @Test
    fun testAllFrequenciesTwo() {
        assertFalse(solution.equalFrequency("aabbcc"))
    }

    @Test
    fun testSingleLetterRepeated() {
        assertTrue(solution.equalFrequency("zz"))
    }
}
