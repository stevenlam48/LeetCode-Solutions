package removealladjacentduplicatesinstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAllAdjacentDuplicatesInStringTest {
    @Test
    fun standardExample() {
        assertEquals("ca", Solution().removeDuplicates("abbaca"))
    }

    @Test
    fun cascadingDuplicates() {
        assertEquals("ay", Solution().removeDuplicates("azxxzy"))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().removeDuplicates(""))
    }

    @Test
    fun everythingIsRemoved() {
        assertEquals("", Solution().removeDuplicates("aaaa"))
    }
}
