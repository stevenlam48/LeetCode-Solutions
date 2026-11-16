package removealladjacentduplicatesinstringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAllAdjacentDuplicatesInStringIiTest {
    @Test
    fun noGroupReachesK() {
        assertEquals("abcd", Solution().removeDuplicates("abcd", 2))
    }

    @Test
    fun standardExample() {
        assertEquals("aa", Solution().removeDuplicates("deeedbbcccbdaa", 3))
    }

    @Test
    fun longStandardExample() {
        assertEquals("ps", Solution().removeDuplicates("pbbcggttciiippooaais", 2))
    }

    @Test
    fun removalCreatesNewGroup() {
        assertEquals("", Solution().removeDuplicates("abba", 2))
    }
}
