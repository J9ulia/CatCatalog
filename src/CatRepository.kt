package CatCatalog

interface CatRepository {
  fun  find(name: String): Cat
  fun  list(): List<Cat>
  fun  add(cat: Cat)
  fun  delete(cat: Cat)
}