package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.entity.User;
import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.RecordId;
import co.com.sofka.Control.domain.value.UserId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Record extends AggregateEvent<RecordId> {
    protected User user;
    private EntryDate entryDate;

    public Record(RecordId entityId) {
        super(entityId);
    }
}
