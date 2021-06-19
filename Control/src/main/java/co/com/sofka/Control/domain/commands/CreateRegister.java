package co.com.sofka.Control.domain.commands;

import co.com.sofka.Control.domain.value.*;
import co.com.sofka.domain.generic.Command;

public class CreateRegister implements Command {
    private final RegisterId registerId;
    private final UserId userId;
    private final EntryDate entryDate;


    public CreateRegister(RegisterId registerId, UserId userId, EntryDate entryDate) {
        this.registerId = registerId;
        this.userId = userId;
        this.entryDate = entryDate;
    }

    public RegisterId registerId() { return registerId; }

    public UserId userId() {
        return userId;
    }

    public EntryDate entryDate() { return entryDate;
    }
}
