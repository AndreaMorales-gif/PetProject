package co.com.sofka.Control.domain.events;

import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.RegisterId;
import co.com.sofka.Control.domain.value.UserId;
import co.com.sofka.domain.generic.DomainEvent;


public class RegisterCreated extends DomainEvent {
    private final RegisterId registerId;
    private final UserId userId;
    private final EntryDate entryDate;

    public RegisterCreated( RegisterId registerId, UserId userId, EntryDate entryDate) {
        super("register.created");
        this.registerId = registerId;
        this.userId = userId;
        this.entryDate = entryDate;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }

    public UserId UserId() {
        return userId;
    }

    public EntryDate EntryDate() {
        return entryDate;
    }
}
