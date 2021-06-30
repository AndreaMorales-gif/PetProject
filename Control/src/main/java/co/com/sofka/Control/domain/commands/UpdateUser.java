package co.com.sofka.Control.domain.commands;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.Command;

public class UpdateUser implements Command{
    private final UserId userId;
    private final Name name;
    private final Date date;
    private final Email email;

    public UpdateUser(UserId userId, Name name, Date date, Email email) {
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public UserId UserId() { return userId;}

    public Name Name() { return name; }

    public Date Date() { return date; }

    public Email Email() { return email; }
}
