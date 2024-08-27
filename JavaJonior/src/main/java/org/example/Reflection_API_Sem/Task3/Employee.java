package org.example.Reflection_API_Sem.Task3;

import org.example.Reflection_API_Sem.Task3.Annotation.Column;
import org.example.Reflection_API_Sem.Task3.Annotation.Entity;
import org.example.Reflection_API_Sem.Task3.Annotation.Table;

import java.util.UUID;


@Entity
@Table(name = "users")


public class Employee {

    //region Field
    @Column(name = "id" , primaryKey = true)
    private UUID id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;

    //endregion

    //region Getter/Setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //endregion

    //region Constructor

    public Employee( String userName, String email) {

        this.userName = userName;
        this.email = email;
    }


    //endregion


}
