package designvideosharingplatform

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignVideoSharingPlatformTest {
    @Test
    fun testExample() {
        val platform = VideoSharingPlatform()
        assertEquals(0, platform.upload("123"))
        assertEquals(1, platform.upload("456"))
        platform.like(0)
        platform.dislike(1)
        assertArrayEquals(intArrayOf(1, 0), platform.getLikesAndDislikes(0))
        assertArrayEquals(intArrayOf(0, 1), platform.getLikesAndDislikes(1))
        assertEquals(0, platform.getViews(0))
        assertEquals("123", platform.watch(0, 0, 2))
        assertEquals(1, platform.getViews(0))
        assertEquals("1", platform.watch(0, 0, 0))
        assertEquals(2, platform.getViews(0))
        platform.remove(0)
        assertEquals("-1", platform.watch(0, 0, 1))
        assertArrayEquals(intArrayOf(-1), platform.getLikesAndDislikes(0))
        assertEquals(-1, platform.getViews(0))
        assertEquals(0, platform.upload("789"))
        assertEquals("789", platform.watch(0, 0, 2))
    }

    @Test
    fun testWatchSubstringBounds() {
        val platform = VideoSharingPlatform()
        val id = platform.upload("abcdef")
        assertEquals("abc", platform.watch(id, 0, 2))
        assertEquals("def", platform.watch(id, 3, 5))
        assertEquals("ef", platform.watch(id, 4, 9))
        assertEquals("", platform.watch(id, 3, 2))
    }

    @Test
    fun testRemoveInvalid() {
        val platform = VideoSharingPlatform()
        platform.remove(100)
        assertEquals(-1, platform.getViews(100))
        assertArrayEquals(intArrayOf(-1), platform.getLikesAndDislikes(5))
        platform.like(5)
        platform.dislike(5)
        assertEquals(-1, platform.getViews(5))
    }

    @Test
    fun testReusesSmallestAvailableId() {
        val platform = VideoSharingPlatform()
        platform.upload("a")
        platform.upload("b")
        platform.upload("c")
        platform.remove(1)
        platform.remove(0)
        assertEquals(0, platform.upload("d"))
        assertEquals(1, platform.upload("e"))
        assertEquals(3, platform.upload("f"))
    }

    @Test
    fun testCountersResetAfterRemove() {
        val platform = VideoSharingPlatform()
        val id = platform.upload("x")
        platform.like(id)
        platform.like(id)
        platform.dislike(id)
        platform.watch(id, 0, 0)
        platform.remove(id)
        val newId = platform.upload("y")
        assertEquals(id, newId)
        assertArrayEquals(intArrayOf(0, 0), platform.getLikesAndDislikes(newId))
        assertEquals(0, platform.getViews(newId))
    }
}
