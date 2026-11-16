package designanorderedstream

// Time:  O(1), amortized
// Space: O(n)

class OrderedStream(n: Int) {
    private var i = 0
    private val values = arrayOfNulls<String>(n)

    fun insert(id: Int, value: String): List<String> {
        var idx = id - 1
        values[idx] = value
        val result = mutableListOf<String>()
        if (idx != i) {
            return result
        }
        while (i < values.size && values[i] != null) {
            result.add(values[i]!!)
            ++i
        }
        return result
    }
}
