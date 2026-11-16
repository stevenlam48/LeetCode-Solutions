package webcrawlermultithreaded

import java.time.Duration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTimeoutPreemptively
import org.junit.jupiter.api.Test

class WebCrawlerMultithreadedTest {
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
        var result: List<String> = emptyList()
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            result = Solution().crawl("http://news.yahoo.com/news/topics/", FakeParser(graph))
        }
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
        var result: List<String> = emptyList()
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            result = Solution().crawl("http://news.google.com", FakeParser(graph))
        }
        assertEquals(
            setOf("http://news.google.com", "http://news.google.com/news"),
            result.toSet()
        )
    }

    @Test
    fun singleUrlWithoutLinks() {
        var result: List<String> = emptyList()
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            result = Solution().crawl("http://example.com", FakeParser(emptyMap()))
        }
        assertEquals(setOf("http://example.com"), result.toSet())
    }

    @Test
    fun longChain() {
        val pages = 200
        val chain = (0 until pages).associate { i ->
            "http://chain.com/$i" to listOf(
                "http://chain.com/${(i + 1) % pages}",
                "http://chain.com/${(i + 2) % pages}"
            )
        }
        var result: List<String> = emptyList()
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            result = Solution().crawl("http://chain.com/0", FakeParser(chain))
        }
        assertEquals(chain.keys, result.toSet())
    }
}
