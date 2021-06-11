package co.com.sofka.Control.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Date implements ValueObject<String> {
    private final String value;

    public Date(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
