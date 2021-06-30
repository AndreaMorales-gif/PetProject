package co.com.sofka.Control.domain;

import co.com.sofka.Control.domain.value.Date;
import co.com.sofka.Control.domain.value.Email;
import co.com.sofka.Control.domain.value.Name;

public final class UserBuilder {
    protected String idUser;
    protected Name name;
    protected Date date;
    protected Email email;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withIdUser(String idUser) {
        this.idUser = idUser;
        return this;
    }

    public UserBuilder withName(Name name) {
        this.name = name;
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
        User user = new User(null, name, date, email);
        user.setIdUser(idUser);
        return user;
    }
}
