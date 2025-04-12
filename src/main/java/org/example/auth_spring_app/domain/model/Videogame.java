package org.example.auth_spring_app.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "videogames")
public class Videogame {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "videogame_id_seq")
    @SequenceGenerator(name = "videogame_id_seq", sequenceName = "videogame_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "reviewScore")
    private Long reviewScore;
}
