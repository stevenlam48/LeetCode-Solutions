package divideastringintogroupsofsizek

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DivideAStringIntoGroupsOfSizeKTest {
    private val solution = Solution()

    @Test
    fun exactGroups() {
        assertArrayEquals(arrayOf("abc", "def", "ghi"), solution.divideString("abcdefghi", 3, 'x'))
    }

    @Test
    fun fillLastGroup() {
        assertArrayEquals(arrayOf("abc", "def", "ghi", "jxx"), solution.divideString("abcdefghij", 3, 'x'))
    }

    @Test
    fun singleGroup() {
        assertArrayEquals(arrayOf("axx"), solution.divideString("a", 3, 'x'))
    }

    @Test
    fun emptyString() {
        assertArrayEquals(emptyArray<String>(), solution.divideString("", 3, 'x'))
    }
}
