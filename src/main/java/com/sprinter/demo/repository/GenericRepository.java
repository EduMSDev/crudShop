package com.sprinter.demo.repository;

import com.sprinter.demo.model.GenericEntity;
import org.springframework.data.repository.CrudRepository;

/**
 Permite usar la  potencia de la herencia
 * y asi evitar la duplicidad de codigo. Se
 * encarga de unificar los principales metodos del
 * CRUD en una sola clase. Aqui se gestionan las comunicaciones
 * que son similares para los repositorios que hacen contra la base
 * de datos
 * @param <T> Entidad que se quiere usar
 */
public interface GenericRepository<T extends GenericEntity> extends CrudRepository<T, Long> {

}
