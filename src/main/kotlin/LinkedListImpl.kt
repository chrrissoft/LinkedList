class LinkedListImpl<T> : LinkedList<T> {

    override var head: Node<T>? = null
    override var last: Node<T>? = null

    private fun initHead(element: T) {
        head = Node(data = element)
        last = head
    }

    override fun add(element: T): Boolean {
        return try {
            if (head == null) {
                initHead(element)
                return true
            }

            val newPoint = Node(data = element)
            last?.next = newPoint
            last = newPoint
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addAt(index: Int, element: T): Boolean {
        var wasAdd = false

        if (head == null && index == 0) {
            initHead(element)
            return true
        }

        searchAt(index) { point, indexIsZero ->
            if (indexIsZero) {
                val newPoint = Node(data = element)
                val nextPoint = head
                newPoint.next = nextPoint
                head = newPoint
                wasAdd = true
                return@searchAt
            }

            val newPoint = Node(data = element)
            val nextPoint = point?.next
            newPoint.next = nextPoint
            point?.next = newPoint

            wasAdd = true
        }

        return wasAdd
    }

    override fun addAll(elements: List<T>): Boolean {
        var wasAdd = false
        elements.forEach { wasAdd = add(it) }
        return wasAdd
    }

    override fun getAll(): List<T> {
        return try {
            var point = head
            val list = mutableListOf<T>()
            while (point != null) {
                list.add(point.data)
                point = point.next
            }

            return list
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun getAt(index: Int): T? {
        var point: Node<T>? = null
        searchAt(index) { _point, isZero ->
            point = if (isZero) head
            else _point?.next
        }
        return point?.data
    }

    override fun replace(oldElement: T, newElement: T): Boolean {
        var replaced = false

        search(oldElement) { point, elementIsHead ->
            val newPoint = Node(newElement)

            if (elementIsHead) {
                val nextPoint = head?.next
                head = newPoint
                newPoint.next = nextPoint
                replaced = true
                return@search
            }

            val nextPoint = point?.next?.next
            point?.next = newPoint
            newPoint.next = nextPoint
            replaced = true
        }

        return replaced
    }

    override fun replaceAt(index: Int, element: T): Boolean {
        var replaced = false
        searchAt(index) { point, indexIsZero ->
            if (indexIsZero) {
                val newPoint = Node(data = element)
                newPoint.next = head?.next
                head = newPoint
                replaced = true
                return@searchAt
            }

            if (point?.next != null) {
                val newPoint = Node(element)
                val nextPoint = point.next?.next
                point.next = newPoint
                newPoint.next = nextPoint
                replaced = true
            }

        }
        return replaced
    }

    override fun replaceHead(newElement: T): Boolean {
        return if (head != null)
            replace(head!!.data, newElement)
        else false
    }

    override fun remove(element: T): Boolean {
        var replaced = false

        search(element) { point, elementIsHead ->

            if (elementIsHead && head != null) {
                head = head?.next
                replaced = true
                return@search
            }

            val nextPoint = point?.next?.next
            point?.next = nextPoint
            replaced = true
        }

        return replaced
    }

    override fun removeAt(index: Int): Boolean {
        var removed = false
        searchAt(index) { point, indexIsZero ->
            if (indexIsZero) {
                val nextPoint = head?.next
                head = nextPoint
                removed = true
                return@searchAt
            }

            if (point?.next?.next != null) {
                point.next = point.next?.next
                removed = true
            } else if (point?.next != null) {
                point.next = null
                removed = true
            } else removed = false
        }
        return removed
    }

    override fun removeAll(): Boolean {
        var wasRemoved = false
        getAll().forEachIndexed { i, _ ->
            wasRemoved = removeAt(i)
        }
        return wasRemoved
    }

    private fun searchAt(
        index: Int,
        operation: (point: Node<T>?, indexIsZero: Boolean) -> Unit
    ) {
        try {
            if (index < 0) return

            var point = head
            var count = 0

            while (point != null) {

                if (index == 0) {
                    operation(point, true)
                    return
                }

                if (index == count.plus(1)) {
                    operation(point, false)
                    return
                } else {
                    count++
                    point = point.next
                }
            }
        } catch (_: Exception) {
        }
    }

    private fun search(
        element: T,
        operation: (point: Node<T>?, elementIsHead: Boolean) -> Unit
    ) {
        try {
            var point = head

            while (point != null) {
                if (element === head?.data) {
                    operation(point, true)
                    return
                }

                if (element === point.next?.data) {
                    operation(point, false)
                    return
                } else point = point.next
            }
        } catch (_: Exception) {
        }
    }

    override fun isEmpty() = getAll().isEmpty()

    override fun isNotEmpty() = getAll().isNotEmpty()

    override fun size() = getAll().size
}