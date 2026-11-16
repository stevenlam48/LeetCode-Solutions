package designauthenticationmanager

// Time:  ctor:     O(1)
//        generate: O(1), amortized
//        renew:    O(1), amortized
//        count:    O(1), amortized
// Space: O(n)

class AuthenticationManager(private val timeToLive: Int) {
    private val lookup = LinkedHashMap<String, Int>()

    fun generate(tokenId: String, currentTime: Int) {
        evict(currentTime)
        lookup[tokenId] = timeToLive + currentTime
    }

    fun renew(tokenId: String, currentTime: Int) {
        evict(currentTime)
        if (!lookup.containsKey(tokenId)) {
            return
        }
        lookup.remove(tokenId)
        lookup[tokenId] = timeToLive + currentTime
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        evict(currentTime)
        return lookup.size
    }

    private fun evict(currentTime: Int) {
        while (lookup.isNotEmpty()) {
            val entry = lookup.entries.first()
            if (entry.value <= currentTime) {
                lookup.remove(entry.key)
            } else {
                break
            }
        }
    }
}
