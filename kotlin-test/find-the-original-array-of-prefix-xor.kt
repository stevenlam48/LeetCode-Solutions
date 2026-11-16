package findtheoriginalarrayofprefixxor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheOriginalArrayOfPrefixXorTest {
    private val solution = Solution()

    @Test
    fun reconstructsLeetCodeExample() {
        val pref = intArrayOf(5, 2, 0, 3, 1)
        assertArrayEquals(intArrayOf(5, 7, 2, 3, 2), solution.findArray(pref))
    }

    @Test
    fun singleValueIsAlreadyOriginal() {
        assertArrayEquals(intArrayOf(13), solution.findArray(intArrayOf(13)))
    }

    @Test
    fun zeroPrefixValuesAreHandled() {
        val pref = intArrayOf(0, 1, 3, 6)
        assertArrayEquals(intArrayOf(0, 1, 2, 5), solution.findArray(pref))
    }

    @Test
    fun conversionIsInPlace() {
        val pref = intArrayOf(7, 4, 1)
        val result = solution.findArray(pref)
        assertSame(pref, result)
        assertArrayEquals(intArrayOf(7, 3, 5), result)
    }

    @Test
    fun emptyArrayRemainsEmpty() {
        assertArrayEquals(intArrayOf(), solution.findArray(intArrayOf()))
    }
}
