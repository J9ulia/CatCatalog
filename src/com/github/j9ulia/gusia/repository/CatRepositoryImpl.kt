package com.github.j9ulia.gusia.repository

import com.github.j9ulia.gusia.model.Cat

class CatRepositoryImpl : CatRepository {
    private val catsMap = mutableMapOf<String, Cat>()

    override fun find(name: String): Cat {
        return catsMap[name] ?: throw IllegalArgumentException("Cat $name doesn't find")
    }

    override fun list(): List<Cat> {
        return catsMap.values.toList()
    }

    override fun add(cat: Cat) {
        catsMap[cat.name] = cat
    }

    override fun delete(cat: Cat) {
        catsMap.remove(cat.name) ?: throw IllegalArgumentException("Cat ${cat.name} doesn't find")
    }
}