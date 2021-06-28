package co.com.sofka.Control.domain.events;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.DomainEvent;

public class UserCreated extends DomainEvent {
    private final UserId userId;
    private final Name name;
    private final Role role;
    private final Date date;
    private final Email email;

    public UserCreated(UserId userId, Name name, Role role, Date date, Email email) {
        super("user.created");
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
