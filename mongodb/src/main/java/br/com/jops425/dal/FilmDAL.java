package br.com.jops425.dal;


import br.com.jops425.model.Film;

import java.util.List;

public interface FilmDAL {

    List<Film> getAllFilms();

    Film getFilmById(Long idFilm);

    Film addNewFilm(Film film);

//    Film getFilmByYear(Integer year);
//
//    Film getFilmByDirector(String director);
//
//    Film getFilmByName(String name);

}
