package br.com.jops425.dal;

import br.com.jops425.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDALImpl implements FilmDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Film> getAllFilms() {
        return mongoTemplate.findAll(Film.class);
    }

    @Override
    public Film getFilmById(Long idFilm) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(idFilm));
        return mongoTemplate.findOne(query, Film.class);
    }

    @Override
    public Film addNewFilm(Film film) {
        mongoTemplate.save(film);
        return film;
    }

//    @Override
//    public Film getFilmByYear(Integer year) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("year").is(year));
//        return mongoTemplate.findOne(query, Film.class);
//    }
//
//    @Override
//    public Film getFilmByDirector(String director) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("director").is(director));
//        return mongoTemplate.findOne(query, Film.class);
//    }
//
//    @Override
//    public Film getFilmByName(String name) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//        return mongoTemplate.findOne(query, Film.class);
//    }


}
