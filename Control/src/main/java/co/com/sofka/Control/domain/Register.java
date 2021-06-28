package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.RegisterId;
import co.com.sofka.Control.domain.value.UserId;
import co.com.sofka.domain.generic.AggregateRoot;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RegisterAndrea")
public class Register extends AggregateRoot<RegisterId> {
    @Id
    protected String idRegister;

    protected UserId userId;
    protected EntryDate entryDate;

    public Register(RegisterId entityId, UserId userId, EntryDate entryDate) {
        super(entityId);
        this.idRegister = entityId.value();
        this.entryDate = entryDate;
        this.userId = userId;
    }
    public void setIdRegister(String idRegister) {
        this.idRegister = idRegister;
    }

    public String getIdRegister() { return idRegister; }

    public UserId getUserId() {
        return userId;
    }

    public EntryDate getEntryDate() {
        return entryDate;
    }
}
