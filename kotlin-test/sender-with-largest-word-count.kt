package senderwithlargestwordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SenderWithLargestWordCountTest {
    @Test
    fun exampleAliceWins() {
        assertEquals(
            "Alice",
            Solution().largestWordCount(
                listOf("Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"),
                listOf("Alice", "userTwo", "userThree", "Alice"),
            ),
        )
    }

    @Test
    fun tieBreaksLexicographically() {
        assertEquals(
            "Charlie",
            Solution().largestWordCount(
                listOf("How is leetcode for everyone", "Leetcode is useful for practice"),
                listOf("Bob", "Charlie"),
            ),
        )
    }

    @Test
    fun singleMessage() {
        assertEquals("z", Solution().largestWordCount(listOf("hi"), listOf("z")))
    }

    @Test
    fun tieUsesLargerName() {
        assertEquals(
            "b",
            Solution().largestWordCount(listOf("a b", "c d"), listOf("b", "a")),
        )
    }
}
