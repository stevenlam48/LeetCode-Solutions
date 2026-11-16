package webcrawler

// Time:  O(|V| + |E|)
// Space: O(|V|)

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface HtmlParser {
    fun getUrls(url: String): List<String>
}

class Solution {
    fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
        val result = mutableListOf(startUrl)
        val lookup = hashSetOf(startUrl)
        var i = 0
        while (i < result.size) {
            val fromUrl = result[i]
            val name = hostname(fromUrl)
            for (toUrl in htmlParser.getUrls(fromUrl)) {
                if (toUrl !in lookup && name == hostname(toUrl)) {
                    result.add(toUrl)
                    lookup.add(toUrl)
                }
            }
            ++i
        }
        return result
    }

    private fun hostname(url: String): String {
        val scheme = "http://"
        val idx = url.indexOf('/', scheme.length)
        return if (idx == -1) url else url.substring(0, idx)
    }
}
