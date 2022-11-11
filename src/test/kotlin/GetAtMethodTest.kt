import org.junit.Test

internal class GetAtMethodTest {

    data class Data(val data: Int)

    @Test
    fun `it can gets the last element`() {
        val instance = linkedList<Data>()
        instance.addAt(0, Data(0))
        assert(instance.getAt(0) != null)
    }

    @Test
    fun `when head is null, it gets null`() {
        val instance = linkedList<Data>()
        assert(instance.getAt(0) == null)
    }

    @Test
    fun `when index does not exist, it gets null`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(0), Data(0)))
        assert(instance.getAt(100) == null)
    }

    @Test
    fun `when index is negative, it gets null`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(0), Data(0)))
        assert(instance.getAt(-1) == null)
    }

}