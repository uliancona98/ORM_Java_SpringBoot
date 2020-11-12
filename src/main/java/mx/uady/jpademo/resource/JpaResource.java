package mx.uady.jpademo.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.uady.jpademo.model.Alumno;
import mx.uady.jpademo.model.Profesor;
import mx.uady.jpademo.model.Tutoria;
import mx.uady.jpademo.model.Usuario;
import mx.uady.jpademo.repository.AlumnoRepository;
import mx.uady.jpademo.repository.ProfesorRepository;
import mx.uady.jpademo.repository.TutoriaRepository;
import mx.uady.jpademo.repository.UsuarioRepository;
import mx.uady.jpademo.request.AlumnoRequest;
import mx.uady.jpademo.request.AlumnoUpdateRequest;
import mx.uady.jpademo.request.UsuarioRequest;
import mx.uady.jpademo.request.ProfesorRequest;
import mx.uady.jpademo.request.UsuarioUpdateRequest;

@RestController
@RequestMapping("/api")
public class JpaResource {

    final Logger LOG = LoggerFactory.getLogger(JpaResource.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TutoriaRepository tutoriaRepository;

    @GetMapping("/alumnos")
    public List<Alumno> alumnos() {
        LOG.debug("Llamada a GET de alumnos");
        List<Alumno> alumnos = new LinkedList<>();
        alumnoRepository.findAll().iterator().forEachRemaining(alumnos::add);
        return alumnos;
    }

    @GetMapping("/alumnos/{id}")
    public Alumno alumno(@PathVariable String id) {
        LOG.debug("Llamada a GET de alumno especifico con id: "+id+".");
        return alumnoRepository.findById(Integer.parseInt(id)).get();
    }

    @PostMapping("/alumnos")
    public Alumno saveAlumno(@RequestBody @Valid AlumnoRequest request){
        LOG.debug("Llamada a crear alumno");
        Alumno alumno = new Alumno();
        alumno.setId(request.getId());
        alumno.setNombre(request.getNombre());
        alumno.setLicenciatura(request.getLicenciatura());
        alumno.setUsuarioId(saveUsuario(request.getId(),request.getUsuario()));
        alumnoRepository.save(alumno);
        return alumno;
    }

    @PutMapping("/alumnos/{id}")
    public Alumno updateAlumno(@RequestBody @Valid AlumnoUpdateRequest request, @PathVariable String id){
        LOG.debug("Llamada a actualizar alumno con id: " + id + ".");
        Optional<Alumno> optional = alumnoRepository.findById(Integer.parseInt(id));
        if(!optional.isPresent()){
            LOG.debug("El alumno no existe.");
            return null;
        }
        Alumno alumno = optional.get();
        alumno.setNombre(request.getNombre());
        alumno.setLicenciatura(request.getLicenciatura());
        alumnoRepository.save(alumno);
        return alumno;
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable String id){
        LOG.debug("Llamada a eliminar alumno con id: " + id + ".");
        Alumno alumno = alumnoRepository.findById(Integer.parseInt(id)).get();
        /*Set<Tutoria> tutores = alumno.getTutorias();
        for(Tutoria t : tutores){
            LOG.debug("Intento de eliminar tutoria.");
            tutoriaRepository.delete(t);
        }*/
        LOG.debug("Eliminacion de alumno");
        alumnoRepository.deleteById(Integer.parseInt(id));
        LOG.debug("Eliminacion de usuario");
        usuarioRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

    public Usuario saveUsuario(Integer id, String usuario){
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setId(id);
        usuarioNuevo.setUsuario(usuario);
        usuarioRepository.save(usuarioNuevo);
        return usuarioNuevo;
    }

    @GetMapping("/usuarios")
    public List<Usuario> usuarios() {
        List<Usuario> usuarios = new LinkedList<>();
        usuarioRepository.findAll().iterator().forEachRemaining(usuarios::add);
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario usuario(@PathVariable String id) {
        return usuarioRepository.findById(Integer.parseInt(id)).get();
    }

    @PostMapping("/usuarios")
    public Usuario saveUsuario(@RequestBody @Valid UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setId(request.getId());
        usuario.setUsuario(request.getUsuario());
        usuarioRepository.save(usuario);
        return usuario;
    }

    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(@RequestBody @Valid UsuarioUpdateRequest request, @PathVariable String id){
        Optional<Usuario> optional = usuarioRepository.findById(Integer.parseInt(id));
        if(!optional.isPresent()){
            return null;
        }
        Usuario usuario = optional.get();
        usuario.setUsuario(request.getUsuario());
        usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id){
        usuarioRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profesores")
    public List<Profesor> profesores(@RequestHeader HttpHeaders headers) {
        List<Profesor> profesores = new LinkedList<>();
        profesorRepository.findAll().iterator().forEachRemaining(profesores::add);
        return profesores;
    }

    @GetMapping("/profesores/{id}")
    public Profesor profesor(@PathVariable String id) {
        Optional<Profesor> optional = profesorRepository.findById(Integer.parseInt(id));
        if (!optional.isPresent()) {
        }
        return optional.get();
    }

    @PostMapping("/profesores")
    public Profesor saveProfesor(@RequestBody @Valid ProfesorRequest request){
        Profesor profesor = new Profesor();
        profesor.setId(request.getId());
        profesor.setNombre(request.getNombre());
        profesorRepository.save(profesor);
        return profesor;
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable String id){
        LOG.debug("Llamada a eliminar profesor con id: " + id + ".");
        Profesor profesor = profesorRepository.findById(Integer.parseInt(id)).get();
        /*Set<Tutoria> tutores = profesor.getTutorias();
        for(Tutoria t : tutores){
            LOG.debug("Intento de eliminar tutoria.");
            tutoriaRepository.delete(t);
        }*/
        LOG.debug("Eliminacion de profesor");
        profesorRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/profesores/{id}")
    public Profesor updateProfesor(@RequestBody @Valid ProfesorRequest request, @PathVariable String id){
        LOG.debug("Llamada a actualizar alumno con id: " + id + ".");
        Optional<Profesor> optional = profesorRepository.findById(Integer.parseInt(id));
        if(!optional.isPresent()){
            LOG.debug("El profesor no existe.");
            return null;
        }
        Profesor profesor = optional.get();
        profesor.setNombre(request.getNombre());
        profesorRepository.save(profesor);
        return profesor;
    }


}