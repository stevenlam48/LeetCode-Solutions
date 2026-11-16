package shiftdistancebetweentwostrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShiftDistanceBetweenTwoStringsTest {
    @Test
    fun choosesForwardAndBackwardSteps() {
        assertEquals(1L, Solution().shiftDistance("a", "b", IntArray(26) { 1 }, IntArray(26) { 1 }))
        assertEquals(1L, Solution().shiftDistance("b", "a", IntArray(26) { 100 }, IntArray(26) { 1 }))
    }

    @Test
    fun allowsWrappingAroundAlphabet() {
        assertEquals(1L, Solution().shiftDistance("z", "a", IntArray(26) { 1 }, IntArray(26) { 100 }))
        assertEquals(1L, Solution().shiftDistance("a", "z", IntArray(26) { 100 }, IntArray(26) { 1 }))
    }

    @Test
    fun accumulatesAcrossEqualAndDifferentCharacters() {
        assertEquals(10L, Solution().shiftDistance("abc", "bca", IntArray(26) { 2 }, IntArray(26) { 3 }))
        assertEquals(0L, Solution().shiftDistance("same", "same", IntArray(26) { 7 }, IntArray(26) { 9 }))
    }

    @Test
    fun usesLongForLargeCosts() {
        assertEquals(
            4294967294L,
            Solution().shiftDistance("aa", "bb", IntArray(26) { Int.MAX_VALUE }, IntArray(26) { Int.MAX_VALUE })
        )
    }
}
