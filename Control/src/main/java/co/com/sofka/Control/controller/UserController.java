package co.com.sofka.Control.controller;

import co.com.sofka.Control.domain.commands.CreateRegister;
import co.com.sofka.Control.domain.commands.CreateUser;
import co.com.sofka.Control.domain.commands.UpdateUser;
import co.com.sofka.Control.domain.events.UserCreated;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.value.*;
import co.com.sofka.Control.useCase.CreateRegisterUseCase;
import co.com.sofka.Control.useCase.CreateUserUseCase;
import co.com.sofka.Control.useCase.TransformationUserUseCase;
import co.com.sofka.Control.useCase.UpdateUserUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private CreateUserUseCase useCase;
    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private TransformationUserUseCase transformationUserUseCase;

    @PostMapping(value = "api/{userId}/{name}/{role}/{date}/{email}")
    public String save(@PathVariable("userId")String userId,
                       @PathVariable("name")String name,
                       @PathVariable("role")String role,
                       @PathVariable("date")String date,
                       @PathVariable("email")String email)
    {
        var command = new CreateUser(UserId.of(userId), new Name(name),new Role(role),new Date(date),new Email(email));
        CreateUserUseCase.Response userCreated = executedUseCase(command);
        return (userCreated.getResponse().getName().value()+
                " "+userCreated.getResponse().getRole().value()+
                " "+userCreated.getResponse().getDate().value()+
                " "+userCreated.getResponse().getEmail().value());
    }

    @PutMapping(value = "api/update/{userId}/{name}/{role}/{date}/{email}")
    public String update (@PathVariable("userId")String userId,
                          @PathVariable("name")String name,
                          @PathVariable("role")String role,
                          @PathVariable("date")String date,
                          @PathVariable("email")String email)
    {
        var command = new UpdateUser(UserId.of(userId),
                new Name(name),
                new Role(role),
                new Date(date),
                new Email(email));

        UpdateUserUseCase.Response userUpdated = executedUseCase(command);
        return (userUpdated.getResponse().getName().value()+
                " "+userUpdated.getResponse().getRole().value()+
                " "+userUpdated.getResponse().getDate().value()+
                " "+userUpdated.getResponse().getEmail().value());

    }
    private UpdateUserUseCase.Response executedUseCase(UpdateUser command) {
        var events= UseCaseHandler.getInstance()
                .syncExecutor(updateUserUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var UserUpdated = events;
        return (UpdateUserUseCase.Response)UserUpdated;
    }

    private CreateUserUseCase.Response executedUseCase(CreateUser command) {
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var UserCreated = events;
        return UserCreated;
    }

    @DeleteMapping(value = "api/deleteUsers/{id}")
    public String delete(@PathVariable("id") String id){ return (transformationUserUseCase.delete(id)); }
}
