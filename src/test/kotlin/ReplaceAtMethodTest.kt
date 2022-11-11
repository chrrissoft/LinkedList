import org.junit.Test

internal class ReplaceAtMethodTest {

    data class Data(val data: Int = 0)

    @Test
    fun `if head is null and index is 0, not replace and return false`() {
        val instance = linkedList<Data>()
        val operation = instance.replaceAt(0, Data())
        assert(!operation && instance.isEmpty())
    }

    @Test
    fun `it does replaced the head correct element`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(1), Data(2)))

        val newHead = Data(1000)
        instance.replaceAt(0, newHead)
        assert(instance.getAt(0).hashCode() == newHead.hashCode())
    }

    @Test
    fun `it does replaced the last element correctly`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(1), Data(2)))
        val newLast = Data(1000)

        instance.replaceAt(2, newLast)
        assert(instance.getAt(2).hashCode() == newLast.hashCode())
    }

    @Test
    fun `it does replace the element correctly`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(), Data(), Data()))
        val newLast = Data()

        instance.replaceAt(1, newLast)
        assert(instance.getAt(1).hashCode() == newLast.hashCode())
    }

    @Test
    fun `the size be keep`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(1), Data(2)))
        val newElement = Data(1000)

        val before = instance.getAll().size
        instance.replaceAt(1, newElement)
        val after = instance.getAll().size

        assert(before == after)
    }

    @Test
    fun `if element is replaced return true, else return false`() {
        val instance = linkedList<Data>()

        val element = Data(0)

        val wasNotReplaced0 = instance.replaceAt(10, element)
        val wasNotReplaced1 = instance.replaceAt(0, element)

        instance.addAll(listOf(Data(0), Data(0), Data(0)))
        val wasNotReplaced2 = instance.replaceAt(3, element)
        val wasNotReplaced3 = instance.replaceAt(4, element)

        val wasReplaced0 = instance.replaceAt(0, element)
        val wasReplaced1 = instance.replaceAt(1, element)

        val wasNotReplaced = !wasNotReplaced0 && !wasNotReplaced1 && !wasNotReplaced2 && !wasNotReplaced3
        val wasReplaced = wasReplaced0 && wasReplaced1
        assert(wasNotReplaced && wasReplaced)
    }

}





