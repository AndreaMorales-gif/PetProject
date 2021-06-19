package co.com.sofka.Control.domain.value;

import co.com.sofka.domain.generic.Identity;

public class UserId extends Identity {
    private UserId(String id){
        super(id);
    }

    public static UserId of(String id){
        return new UserId(id);
    }
}
