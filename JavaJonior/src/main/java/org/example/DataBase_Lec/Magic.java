package org.example.DataBase_Lec;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.Reflection_API_Sem.Task3.Annotation.Column;
import org.example.Reflection_API_Sem.Task3.Annotation.Entity;
import org.example.Reflection_API_Sem.Task3.Annotation.Table;



@Entity
@Table(name = "test.magic")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "название")
    private String name;

    @Column(name = "повреждение")
    private int damage;
    @Column(name = "атака")
    private int attBonus;



    public Magic( String name, int damage, int attBonus) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
    }
}
