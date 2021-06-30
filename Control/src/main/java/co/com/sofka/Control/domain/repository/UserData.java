package co.com.sofka.Control.domain.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersAndrea")
public class UserData {

    @Id
    protected String id;

    protected String name;
    protected String date;
    protected String email;

    public UserData(String id, String name, String date, String email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public UserData(){
    }

    public void setId(String idUser) {
        this.id = idUser;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
