package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.UserId;

public final class RegisterBuilder {
    protected UserId userId;
    protected EntryDate entryDate;

    private RegisterBuilder() {
    }

    public static RegisterBuilder aRegister() {
        return new RegisterBuilder();
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
        return new Register(null, userId, entryDate);
    }
}
