package smallestcommonregion

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestCommonRegionTest {
    private val solution = Solution()

    private val regions = listOf(
        listOf("Earth", "North America", "South America"),
        listOf("North America", "United States", "Canada"),
        listOf("United States", "New York", "Boston"),
        listOf("Canada", "Ontario", "Quebec"),
        listOf("South America", "Brazil")
    )

    @Test
    fun testExample1() {
        assertEquals("North America", solution.findSmallestRegion(regions, "Quebec", "New York"))
    }

    @Test
    fun testExample2() {
        assertEquals("Earth", solution.findSmallestRegion(regions, "Canada", "South America"))
    }

    @Test
    fun testExample3() {
        assertEquals("North America", solution.findSmallestRegion(regions, "Boston", "Canada"))
    }

    @Test
    fun testSameRegion() {
        assertEquals("Quebec", solution.findSmallestRegion(regions, "Quebec", "Quebec"))
    }

    @Test
    fun testAncestorAndDescendant() {
        assertEquals("United States", solution.findSmallestRegion(regions, "United States", "Boston"))
    }
}
