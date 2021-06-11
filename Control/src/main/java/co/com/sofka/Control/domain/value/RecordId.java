package co.com.sofka.Control.domain.value;

import co.com.sofka.domain.generic.Identity;

public class RecordId extends Identity {
    public RecordId(String uid){
        super(uid);
    }

    public RecordId(){
    }

    public static RecordId of(String uid){
        return new RecordId(uid);
    }
}
