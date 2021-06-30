package co.com.sofka.Control.domain.events;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.DomainEvent;

public class UserUpdated extends DomainEvent {
    private final UserId userId;
    private final Name name;
    private final Date date;
    private final Email email;

    public UserUpdated(UserId userId, Name name, Date date, Email email) {
        super("user.updated");
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public UserId UserId() { return userId; }

    public Name Name() { return name; }

    public Date Date() { return date; }

    public Email Email() { return email; }
}
