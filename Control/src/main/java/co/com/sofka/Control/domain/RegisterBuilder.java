package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.UserId;

public final class RegisterBuilder {
    protected String idRegister;
    protected UserId userId;
    protected EntryDate entryDate;

    private RegisterBuilder() {
    }

    public static RegisterBuilder aRegister() {
        return new RegisterBuilder();
    }

    public RegisterBuilder withIdRegister(String idRegister) {
        this.idRegister = idRegister;
        return this;
    }

    public RegisterBuilder withUserId(UserId userId) {
        this.userId = userId;
        return this;
    }

    public RegisterBuilder withEntryDate(EntryDate entryDate) {
        this.entryDate = entryDate;
        return this;
    }

    public Register build() {
        Register register = new Register(null, userId, entryDate);
        register.setIdRegister(idRegister);
        return register;
    }
}
