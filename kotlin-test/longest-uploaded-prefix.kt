package longestuploadedprefix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUploadedPrefixTest {
    @Test
    fun testExampleSequence() {
        val prefix = LUPrefix(4)
        assertEquals(0, prefix.longest())
        prefix.upload(3)
        assertEquals(0, prefix.longest())
        prefix.upload(1)
        assertEquals(1, prefix.longest())
        prefix.upload(2)
        assertEquals(3, prefix.longest())
        prefix.upload(4)
        assertEquals(4, prefix.longest())
    }

    @Test
    fun testUploadInOrder() {
        val prefix = LUPrefix(3)
        prefix.upload(1)
        assertEquals(1, prefix.longest())
        prefix.upload(2)
        assertEquals(2, prefix.longest())
        prefix.upload(3)
        assertEquals(3, prefix.longest())
    }

    @Test
    fun testUploadDescending() {
        val prefix = LUPrefix(3)
        prefix.upload(3)
        assertEquals(0, prefix.longest())
        prefix.upload(2)
        assertEquals(0, prefix.longest())
        prefix.upload(1)
        assertEquals(3, prefix.longest())
    }

    @Test
    fun testDuplicateUploads() {
        val prefix = LUPrefix(2)
        prefix.upload(1)
        prefix.upload(1)
        assertEquals(1, prefix.longest())
        prefix.upload(2)
        prefix.upload(2)
        assertEquals(2, prefix.longest())
    }

    @Test
    fun testSingleVideo() {
        val prefix = LUPrefix(1)
        assertEquals(0, prefix.longest())
        prefix.upload(1)
        assertEquals(1, prefix.longest())
    }
}
