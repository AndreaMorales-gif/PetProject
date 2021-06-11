package co.com.sofka.Control.domain.entity;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.Entity;

public class User extends Entity<UserId> {
    private Name name;
    private Role role;
    private Date date;
    private Email email;

    public User(UserId entityId, Name name, Role role, Date date, Email email) {
        super(entityId);
        this.name = name;
        this.role = role;
        this.date = date;
        this.email = email;
    }

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
