package findallnumbersdisappearedinanarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllNumbersDisappearedInAnArrayIiTest {
    @Test
    fun standardRangeExample() {
        val actual = Solution().findDisappearedNumbers(intArrayOf(0, 1, 3, 50, 75), 0, 99)
        assertEquals(
            listOf(listOf(2, 2), listOf(4, 49), listOf(51, 74), listOf(76, 99)),
            actual.map { it.toList() }
        )
    }

    @Test
    fun allValuesPresent() {
        val actual = Solution().findDisappearedNumbers(intArrayOf(2, 1, 3), 1, 3)
        assertEquals(emptyList<List<Int>>(), actual.map { it.toList() })
    }

    @Test
    fun emptyInputAndOutOfRangeValues() {
        val actual = Solution().findDisappearedNumbers(intArrayOf(-4, 8), 1, 3)
        assertEquals(listOf(listOf(1, 3)), actual.map { it.toList() })
    }
}
