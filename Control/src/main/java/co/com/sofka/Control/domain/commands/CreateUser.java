package co.com.sofka.Control.domain.commands;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.Command;

public class CreateUser implements Command {
    private final UserId userId;
    private final Name name;
    private final Role role;
    private final Date date;
    private final Email email;

    public CreateUser(UserId userId, Name name, Role role, Date date, Email email) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.date = date;
        this.email = email;
    }

    public UserId UserId() { return userId; }

    public Name Name() { return name; }

    public Role Role() { return role; }

    public Date Date() { return date; }

    public Email Email() { return email; }


}
