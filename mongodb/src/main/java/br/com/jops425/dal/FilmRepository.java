package br.com.jops425.dal;

import br.com.jops425.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, Long> {
}
