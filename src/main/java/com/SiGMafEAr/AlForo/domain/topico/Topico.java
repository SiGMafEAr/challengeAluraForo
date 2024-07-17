package com.SiGMafEAr.AlForo.domain.topico;

import com.SiGMafEAr.AlForo.domain.curso.Curso;
import com.SiGMafEAr.AlForo.domain.respuesta.Respuesta;
import com.SiGMafEAr.AlForo.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;
    private Boolean activo;

    public Topico(String titulo, String mensaje, Usuario usuario, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();;
        this.status = "1";
        this.usuario = usuario;
        this.curso = curso;
        this.activo = true;
    }


    public void desactivarTopico() {
        this.activo = false;
    }

    public void actualizarTopico(String titulo, String mensaje, String status, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.curso = curso;
    }
}
