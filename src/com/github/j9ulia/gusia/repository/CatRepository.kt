package com.github.j9ulia.gusia.repository

import com.github.j9ulia.gusia.model.Cat


interface CatRepository {
  fun  find(name: String): Cat
  fun  list(): List<Cat>
  fun  add(cat: Cat)
  fun  delete(cat: Cat)
}