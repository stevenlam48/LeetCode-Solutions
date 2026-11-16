package webcrawler

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WebCrawlerTest {
    private class FakeParser(private val graph: Map<String, List<String>>) : HtmlParser {
        override fun getUrls(url: String): List<String> = graph[url] ?: emptyList()
    }

    private val graph = mapOf(
        "http://news.yahoo.com" to listOf(
            "http://news.yahoo.com/news",
            "http://news.yahoo.com/news/topics/",
            "http://news.yahoo.com/us"
        ),
        "http://news.yahoo.com/news" to listOf(
            "http://news.yahoo.com",
            "http://news.yahoo.com/news/topics/"
        ),
        "http://news.yahoo.com/news/topics/" to listOf(
            "http://news.yahoo.com",
            "http://news.yahoo.com/news"
        ),
        "http://news.yahoo.com/us" to listOf(
            "http://news.yahoo.com/news/topics/",
            "http://news.yahoo.com"
        ),
        "http://news.google.com" to listOf(
            "http://news.yahoo.com/news",
            "http://news.google.com/news"
        )
    )

    @Test
    fun example() {
        val result = Solution().crawl("http://news.yahoo.com/news/topics/", FakeParser(graph))
        assertEquals(
            setOf(
                "http://news.yahoo.com",
                "http://news.yahoo.com/news",
                "http://news.yahoo.com/news/topics/",
                "http://news.yahoo.com/us"
            ),
            result.toSet()
        )
    }

    @Test
    fun otherHostsAreIgnored() {
        val result = Solution().crawl("http://news.google.com", FakeParser(graph))
        assertEquals(
            setOf("http://news.google.com", "http://news.google.com/news"),
            result.toSet()
        )
    }

    @Test
    fun singleUrlWithoutLinks() {
        val result = Solution().crawl("http://example.com", FakeParser(emptyMap()))
        assertEquals(listOf("http://example.com"), result)
    }

    @Test
    fun noDuplicateUrls() {
        val cyclic = mapOf(
            "http://a.com" to listOf("http://a.com/x", "http://a.com/x"),
            "http://a.com/x" to listOf("http://a.com", "http://a.com/x")
        )
        val result = Solution().crawl("http://a.com", FakeParser(cyclic))
        assertEquals(setOf("http://a.com", "http://a.com/x"), result.toSet())
        assertEquals(2, result.size)
    }
}
