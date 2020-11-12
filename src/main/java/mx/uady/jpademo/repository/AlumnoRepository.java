package mx.uady.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.jpademo.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}