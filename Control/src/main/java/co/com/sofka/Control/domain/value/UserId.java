package co.com.sofka.Control.domain.value;

import co.com.sofka.domain.generic.Identity;

public class UserId extends Identity {
    public UserId(String uid){
        super(uid);
    }

    public UserId(){
    }

    public static UserId of(String uid){
        return new UserId(uid);
    }
}
