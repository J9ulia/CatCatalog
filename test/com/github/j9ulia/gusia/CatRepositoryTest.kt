package com.github.j9ulia.gusia

import com.github.j9ulia.gusia.model.Cat
import com.github.j9ulia.gusia.repository.CatRepository
import com.github.j9ulia.gusia.repository.CatRepositoryImpl
import org.junit.Test

class CatRepositoryTest {

    @Test
    fun `can add new cat and find it`() {
        // given
        val repository: CatRepository = CatRepositoryImpl()
        val cat = Cat("Иван", 22.3)

        // when
        repository.add(cat)

        // then
        val catFromRepository = repository.find("Иван")

        assert(catFromRepository == cat) {
            "can't find cat added to the repository"
        }
    }
}