package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.Date;
import co.com.sofka.Control.domain.value.Email;
import co.com.sofka.Control.domain.value.Name;
import co.com.sofka.Control.domain.value.Role;

public final class UserBuilder {
    protected Name name;
    protected Role role;
    protected Date date;
    protected Email email;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public UserBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public UserBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public UserBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public User build() {
        return new User(null, name, role, date, email);
    }
}
