package com.github.j9ulia.gusia

import com.github.j9ulia.gusia.model.Cat
import com.github.j9ulia.gusia.repository.CatRepository
import com.github.j9ulia.gusia.repository.CatRepositoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class CatRepositoryTest {

    @Test
    fun `can add new cat and find it`() {
        // given
        val repository: CatRepository = CatRepositoryImpl()
        val dateOfBirthMyCat: LocalDate = LocalDate.parse("2018-12-12")
        val cat = Cat("Иван", null, dateOfBirthMyCat)

        // when
        repository.add(cat)

        // then
        val catFromRepository = repository.find("Иван")

        assert(catFromRepository == cat) {
            "can't find cat added to the repository"
        }
    }
    @Test
    fun  `cant find nonexistent cat`()  {
        val repository: CatRepository = CatRepositoryImpl()
//        val expectedException: Exception = IllegalArgumentException("Cat Иван doesn't find")
//        try {
//            val catFromRepository = repository.find("Иван")
//        }
//        catch (actualException: Exception) {
//            assertEquals(expectedException.message, actualException.message)
//        }
        val actualException = assertThrows<IllegalArgumentException> {
            repository.find("Иван")
        }
        assertEquals("Cat Иван doesn't find", actualException.message)
    }

    @Test
    fun  `can add new cat and delete it`() {
        val repository: CatRepository = CatRepositoryImpl()
        val dateOfBirthMyCat: LocalDate = LocalDate.parse("2018-12-12")
        val cat = Cat("Иван", null, dateOfBirthMyCat)
        repository.add(cat)
        repository.delete(cat)
        val actualException = assertThrows<IllegalArgumentException> {
            repository.find("Иван")
        }
        assertEquals("Cat Иван doesn't find", actualException.message)
    }

    @Test
    fun  `cant delete nonexistent cat`() {
        val repository: CatRepository = CatRepositoryImpl()
        val dateOfBirthMyCat: LocalDate = LocalDate.parse("2018-12-12")
        val cat = Cat("Иван", null, dateOfBirthMyCat)
        val actualException = assertThrows<IllegalArgumentException> {
            repository.delete(cat)
        }
        assertEquals("Cat Иван doesn't find", actualException.message)
    }

    @Test
    fun  `can add new cats and list them`() {
        val repository: CatRepository = CatRepositoryImpl()
        val dateOfBirthMyCat: LocalDate = LocalDate.parse("2018-12-12")
        val cat1 = Cat("Иван", null, dateOfBirthMyCat)
        val cat2 = Cat("Олег", null, dateOfBirthMyCat)
        val catsMapTest = mutableMapOf<String, Cat>()
        catsMapTest[cat1.name] = cat1
        catsMapTest[cat2.name] = cat2
        repository.add(cat1)
        repository.add(cat2)
        val catsFromRepository = repository.list()
        assert(catsFromRepository == catsMapTest.values.toList()) {
            "can't find cat added to the repository"
        }
    }

    @Test
    fun  `empty list`() {
        val repository: CatRepository = CatRepositoryImpl()
        val emptyList = listOf<Cat>()
        assert(repository.list() == emptyList )

    }
}