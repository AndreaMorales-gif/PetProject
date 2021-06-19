package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.RegisterId;
import co.com.sofka.Control.domain.value.UserId;
import co.com.sofka.domain.generic.AggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "RegisterAndrea")
public class Register extends AggregateRoot<RegisterId> {
    protected UserId userId;
    protected EntryDate entryDate;

    public Register(RegisterId entityId, UserId userId, EntryDate entryDate) {
        super(entityId);
        this.entryDate = entryDate;
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }

    public EntryDate getEntryDate() {
        return entryDate;
    }
}
