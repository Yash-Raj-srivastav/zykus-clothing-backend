package design.zykus.zykus.clothing.entities;

import jakarta.persistence.*;
@Entity
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
