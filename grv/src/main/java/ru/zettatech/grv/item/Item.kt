package ru.zettatech.grv.item

class Item (private var resourceId: Int, private var name: String, private var description: String) {
    fun getResourceId(): Int {
        return resourceId
    }

    fun setResourceId(_resourceId: Int) {
        resourceId = _resourceId
    }

    fun getName(): String {
        return name
    }

    fun setName(_name: String) {
        name = _name
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(_description: String) {
        description = _description
    }
}