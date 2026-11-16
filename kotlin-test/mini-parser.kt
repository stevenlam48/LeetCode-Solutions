package miniparser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MiniParserTest {
    private fun render(ni: NestedInteger): String {
        if (ni.isInteger()) {
            return ni.getInteger().toString()
        }
        return ni.getList().joinToString(",", "[", "]") { render(it) }
    }

    @Test
    fun singleInteger() {
        assertEquals("324", render(Solution().deserialize("324")))
    }

    @Test
    fun nestedList() {
        assertEquals("[123,[456,[789]]]", render(Solution().deserialize("[123,[456,[789]]]")))
    }

    @Test
    fun emptyList() {
        assertEquals("[]", render(Solution().deserialize("[]")))
    }

    @Test
    fun negativeInteger() {
        assertEquals("[-1]", render(Solution().deserialize("[-1]")))
    }

    @Test
    fun listContainingEmptyList() {
        assertEquals("[[]]", render(Solution().deserialize("[[]]")))
    }
}
