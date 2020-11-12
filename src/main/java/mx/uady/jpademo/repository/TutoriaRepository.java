package mx.uady.jpademo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.jpademo.model.Tutoria;
import mx.uady.jpademo.model.Tutoria.TutoriaId;

@Repository
public interface TutoriaRepository extends CrudRepository<Tutoria, TutoriaId> {

}