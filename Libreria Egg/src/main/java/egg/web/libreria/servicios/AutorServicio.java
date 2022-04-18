/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.web.libreria.servicios;

import egg.web.libreria.entidades.Autor;
import egg.web.libreria.errores.ErrorServicio;
import egg.web.libreria.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre2) throws ErrorServicio {
        validar(nombre2);
        Autor autor = new Autor();
        autor.setNombre(nombre2);
        autor.setAlta(Boolean.TRUE);

        autorRepositorio.save(autor);
    }

    public void validar(String nombre) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El campo NOMBRE está vacío");
        }
    }

    @Transactional
    public void modificarAutor(String id, String nombre) throws ErrorServicio {
        validar(nombre);
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = autorRepositorio.findById(id).get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        } else {
            throw new ErrorServicio("No se encontró la editorial pedida.");
        }
    }

    @Transactional
    public void altaAutor(String id) throws ErrorServicio {
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = autorRepositorio.findById(id).get();
            autor.setAlta(Boolean.TRUE);
            autorRepositorio.save(autor);
        } else {
            throw new ErrorServicio("No se encontró la editorial pedida.");
        }
    }

    @Transactional
    public void bajaAutor(String id) throws ErrorServicio {
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = autorRepositorio.findById(id).get();
            autor.setAlta(Boolean.FALSE);
            autorRepositorio.save(autor);
        } else {
            throw new ErrorServicio("No se encontró la editorial pedida.");
        }
    }

    public List<Autor> listadoAutor() {
        return (List<Autor>) autorRepositorio.findAll();
    }

    public Autor buscarPorNombre(String nombre) {
        return autorRepositorio.buscarAutorPorNombre(nombre);
    }

    public Optional<Autor> buscarPorId(String id) {
        return autorRepositorio.findById(id);
    }
}
