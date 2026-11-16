package searchsuggestionssystem

// Time:  ctor: O(n * l), n is the number of products
//                      , l is the average length of product name
//        suggest: O(l^2)
// Space: O(t), t is the number of nodes in trie

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchSuggestionsSystemTest {
    @Test
    fun mouseSuggestions() {
        val products = listOf("mobile", "mouse", "moneypot", "monitor", "mousepad")
        assertEquals(
            listOf(
                listOf("mobile", "moneypot", "monitor"),
                listOf("mobile", "moneypot", "monitor"),
                listOf("mouse", "mousepad"),
                listOf("mouse", "mousepad"),
                listOf("mouse", "mousepad")
            ),
            Solution().suggestedProducts(products, "mouse")
        )
    }

    @Test
    fun unsortedProducts() {
        val products = listOf("box", "bags", "baggage", "cloths", "banner")
        assertEquals(
            listOf(
                listOf("baggage", "bags", "banner"),
                listOf("baggage", "bags", "banner"),
                listOf("baggage", "bags"),
                listOf("bags")
            ),
            Solution().suggestedProducts(products, "bags")
        )
    }

    @Test
    fun noMatches() {
        assertEquals(listOf(emptyList<String>()), Solution().suggestedProducts(listOf("a"), "b"))
    }

    @Test
    fun emptyProducts() {
        assertEquals(listOf(emptyList<String>(), emptyList()), Solution().suggestedProducts(emptyList(), "ab"))
    }

    @Test
    fun emptySearchWord() {
        assertEquals(emptyList<List<String>>(), Solution().suggestedProducts(listOf("a"), ""))
    }
}
