package com.SiGMafEAr.AlForo.domain.respuesta;


import com.SiGMafEAr.AlForo.domain.curso.Curso;
import com.SiGMafEAr.AlForo.domain.topico.Topico;
import com.SiGMafEAr.AlForo.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    private Topico topico;
    private LocalDateTime fechaCreacion;
    private Usuario autor;
    private Boolean solucion;
}
