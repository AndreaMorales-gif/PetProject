package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersAndrea")
public class User extends Entity<UserId> {
    @Id
    protected String idUser;

    protected Name name;
    protected Role role;
    protected Date date;
    protected Email email;

    public User(UserId entityId, Name name, Role role, Date date, Email email) {
        super(entityId);
        this.idUser= entityId.value();
        this.name = name;
        this.role = role;
        this.date = date;
        this.email = email;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() { return idUser; }

    public Name getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Date getDate() {
        return date;
    }

    public Email getEmail() {
        return email;
    }


}
