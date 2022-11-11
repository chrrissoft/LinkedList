import org.junit.Test

internal class RemoveAtMethodTest {

    data class Data(val data: Int)

    @Test
    fun `if size is 1, before operation size will be 0`() {
        val instance = linkedList(Data(0))
        instance.removeAt(0)
        assert(instance.getAll().isEmpty())
    }

    @Test
    fun `if size is 1 and is removed, the next add operation works`() {
        val instance = linkedList(Data(0))
        instance.removeAt(0)
        val head = Data(0)
        instance.addAll(listOf(head, Data(0)))
        assert(instance.getAt(0) == head && instance.getAll().size == 2)
    }

    @Test
    fun `it does remove the head correct element`() {
        val instance = linkedList<Data>()
        val head = Data(1)

        instance.addAll(listOf(Data(0), head, Data(2)))
        instance.removeAt(0)
        println(instance.getAll())
        assert(instance.getAt(0).hashCode() == head.hashCode())
    }

    @Test
    fun `if head is null, return false`() {
        val instance = linkedList<Data>()
        val operation = instance.removeAt(0)
        assert(!operation)
    }

    @Test
    fun `if is next index of last, does not remove`() {
        val instance = linkedList(Data(0))
        val before = instance.getAll().size
        instance.removeAt(1)
        val after = instance.getAll().size
        assert(before == after)
    }

    @Test
    fun `if index is of bounds, return false`() {
        val instance = linkedList(Data(0))
        val operation = instance.removeAt(10)
        assert(!operation)
    }

    @Test
    fun `if element is removed return true, else return false`() {
        val instance = linkedList<Data>()

        val wasNotRemoved0 = instance.removeAt(10)
        val wasNotRemoved1 = instance.removeAt(0)

        instance.addAll(listOf(Data(0), Data(0), Data(0)))
        val wasNotRemoved2 = instance.removeAt(3)
        val wasNotRemoved3 = instance.removeAt(4)

        val wasRemoved0 = instance.removeAt(0)
        val wasRemoved1 = instance.removeAt(1)

        val wasNotRemoved = !wasNotRemoved0 && !wasNotRemoved1 && !wasNotRemoved2 && !wasNotRemoved3
        val wasRemoved = wasRemoved0 && wasRemoved1
        assert(wasNotRemoved && wasRemoved)
    }

}