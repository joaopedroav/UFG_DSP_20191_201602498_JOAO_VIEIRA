package br.com.jops425.controller;

import br.com.jops425.dal.FilmDAL;
import br.com.jops425.dal.FilmRepository;
import br.com.jops425.model.Film;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class FilmController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final FilmRepository filmRepository;

    private final FilmDAL filmDAL;

    public FilmController(FilmRepository filmRepository, FilmDAL filmDAL) {
        this.filmRepository = filmRepository;
        this.filmDAL = filmDAL;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Film addNewFilm(@RequestBody Film film) {
        LOG.info("Saving film");
        return filmRepository.save(film);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Film> getAllFilms() {
        LOG.info("Getting all films.");
        return filmRepository.findAll();
    }

    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    public Film getById(@PathVariable Long filmId) {
        LOG.info("Getting film with ID: {}.", filmId);
        return filmRepository.findOne(filmId);
    }

    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long filmId) {
        LOG.info("Deleting film with ID: {}.", filmId);
        filmRepository.delete(filmId);
    }

}
