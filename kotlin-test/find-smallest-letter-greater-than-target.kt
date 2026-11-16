package findsmallestlettergreaterthantarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSmallestLetterGreaterThanTargetTest {
    @Test
    fun testExample1() {
        assertEquals('c', Solution().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'a'))
    }

    @Test
    fun testExactMatch() {
        assertEquals('f', Solution().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
    }

    @Test
    fun testBetweenLetters() {
        assertEquals('f', Solution().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'd'))
    }

    @Test
    fun testWrapAround() {
        assertEquals('c', Solution().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'j'))
    }

    @Test
    fun testGreaterThanAll() {
        assertEquals('c', Solution().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'z'))
    }

    @Test
    fun testDuplicates() {
        assertEquals('j', Solution().nextGreatestLetter(charArrayOf('c', 'c', 'f', 'j'), 'f'))
    }
}
