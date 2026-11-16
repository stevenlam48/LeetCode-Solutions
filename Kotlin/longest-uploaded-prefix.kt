package longestuploadedprefix

// Time:  ctor:    O(1)
//        upload:  O(1), amortized
//        longest: O(1)
// Space: O(n)

// hash table
class LUPrefix(n: Int) {
    private val lookup = HashSet<Int>()
    private var curr = 0

    fun upload(video: Int) {
        lookup.add(video - 1)
        while (lookup.contains(curr)) {
            lookup.remove(curr)
            ++curr
        }
    }

    fun longest(): Int {
        return curr
    }
}
