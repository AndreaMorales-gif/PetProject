package co.com.sofka.Control.domain.value;

import co.com.sofka.domain.generic.Identity;

public class RegisterId extends Identity {
    private RegisterId(String id){
        super(id);
    }

    public static RegisterId of(String id){
        return new RegisterId(id);
    }
}
