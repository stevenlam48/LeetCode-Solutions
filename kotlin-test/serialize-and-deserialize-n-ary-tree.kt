package serializeanddeserializenarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SerializeAndDeserializeNAryTreeTest {
    @Test
    fun roundTripsExampleTree() {
        val root = node(
            1,
            node(3, node(5), node(6)),
            node(2),
            node(4)
        )
        val codec = Codec()
        val restored = codec.deserialize(codec.serialize(root))
        assertEquals(codec.serialize(root), codec.serialize(restored))
        assertEquals(3, restored!!.children.size)
        assertEquals(5, restored.children[0].children[0].`val`)
    }

    @Test
    fun serializesSingleAndNegativeNodes() {
        val codec = Codec()
        val single = Node(-7)
        assertEquals("-7 # ", codec.serialize(single))
        assertEquals(codec.serialize(single), codec.serialize(codec.deserialize(codec.serialize(single))))
    }

    @Test
    fun handlesEmptyTree() {
        val codec = Codec()
        assertEquals("", codec.serialize(null))
        assertNull(codec.deserialize(""))
    }

    private fun node(value: Int, vararg children: Node): Node {
        return Node(value, children.toMutableList())
    }
}
