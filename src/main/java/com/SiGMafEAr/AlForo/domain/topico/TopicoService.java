package com.SiGMafEAr.AlForo.domain.topico;

import com.SiGMafEAr.AlForo.domain.curso.Curso;
import com.SiGMafEAr.AlForo.curso.CursoRepository;
import com.SiGMafEAr.AlForo.domain.topico.validaciones.ValidadorDeTopicos;
import com.SiGMafEAr.AlForo.domain.usuario.Usuario;
import com.SiGMafEAr.AlForo.domain.usuario.UsuarioRepository;
import com.SiGMafEAr.AlForo.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicoService {


    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    List<ValidadorDeTopicos> validaciones;

    public Topico registrarTopico(RequestTopicoDTO datos){

        if(!usuarioRepository.findById(datos.usuarioId()).isPresent()){
            throw new ValidacionDeIntegridad("este id para el usuario no fue encontrado");
        }
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }

        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }

        Curso curso = cursoRepository.findByNombre(datos.curso());
        Usuario usuario = usuarioRepository.getReferenceById(datos.usuarioId());
        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                usuario,
                curso
        );
        topicoRepository.save(topico);

        return topico;
    }

    public Topico actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datos){
        Topico topico = topicoRepository.getReferenceById(id);
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }
        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }
        Curso curso = cursoRepository.findByNombre(datos.curso());
        topico.actualizarTopico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                curso
        );
        return topico;
    }


    //    public Topico(RequestTopicoDTO datos) {
//        this.titulo = datos.titulo();
//        this.mensaje = datos.mensaje();
//        this.fechaCreacion = LocalDateTime.now();
//        this.status = datos.status();
//        this.usuario = datos.autor();
//        this.curso = datos.curso();
//        this.respuesta = datos.respuesta();
//        this.activo = true;
//    }

    //    public void actualizarTopico(ActualizarTopicoDTO datos) {
//        this.titulo = datos.titulo();
//        this.mensaje = datos.mensaje();
//        this.status = datos.status();
//        this.usuario = datos.autor();
//        this.curso = datos.curso();
//    }
}
