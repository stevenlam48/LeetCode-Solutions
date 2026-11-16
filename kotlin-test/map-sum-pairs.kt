package mapsumpairs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MapSumPairsTest {
    @Test
    fun testLeetCodeExample() {
        val mapSum = MapSum()
        mapSum.insert("apple", 3)
        assertEquals(3, mapSum.sum("ap"))
        mapSum.insert("app", 2)
        assertEquals(5, mapSum.sum("ap"))
    }

    @Test
    fun testOverwriteValue() {
        val mapSum = MapSum()
        mapSum.insert("a", 3)
        assertEquals(3, mapSum.sum("a"))
        mapSum.insert("a", 5)
        assertEquals(5, mapSum.sum("a"))
    }

    @Test
    fun testPrefixOfSeveralKeys() {
        val mapSum = MapSum()
        mapSum.insert("a", 5)
        mapSum.insert("ab", 2)
        assertEquals(7, mapSum.sum("a"))
        assertEquals(2, mapSum.sum("ab"))
    }

    @Test
    fun testMissingPrefix() {
        val mapSum = MapSum()
        mapSum.insert("apple", 3)
        assertEquals(0, mapSum.sum("b"))
        assertEquals(0, mapSum.sum("apples"))
    }

    @Test
    fun testEmptyPrefix() {
        val mapSum = MapSum()
        mapSum.insert("abc", 4)
        assertEquals(0, mapSum.sum(""))
    }

    @Test
    fun testNegativeValues() {
        val mapSum = MapSum()
        mapSum.insert("x", -2)
        mapSum.insert("xy", 5)
        assertEquals(3, mapSum.sum("x"))
    }
}
