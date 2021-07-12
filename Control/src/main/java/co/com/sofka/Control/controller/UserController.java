package co.com.sofka.Control.controller;

import co.com.sofka.Control.domain.commands.CreateRegister;
import co.com.sofka.Control.domain.commands.CreateUser;
import co.com.sofka.Control.domain.commands.UpdateUser;
import co.com.sofka.Control.domain.events.UserCreated;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.repository.UserData;
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

    @PostMapping(value = "api/saveUsers/{userId}/{name}/{date}/{email}")
    public String save(@PathVariable("userId")String userId,
                       @PathVariable("name")String name,
                       @PathVariable("date")String date,
                       @PathVariable("email")String email)
    {
        CreateUser command = new CreateUser(UserId.of(userId),
                new Name(name),
                new Date(date),
                new Email(email));
        CreateUserUseCase.Response userCreated = executedUseCase(command);
        String string = "{"
                + "\"userId\":" + "\""+userCreated.getResponse().identity()+"\""+ ","
                + "\"name\":" + "\""+userCreated.getResponse().getName().value()+"\""+ ","
                + "\"date\":" + "\""+userCreated.getResponse().getDate().value()+"\""+ ","
                + "\"email\":" + "\""+userCreated.getResponse().getEmail().value()
                +"}";
        return string;
    }
    private CreateUserUseCase.Response executedUseCase(CreateUser command) {
        CreateUserUseCase.Response events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        CreateUserUseCase.Response UserCreated = events;
        return UserCreated;
    }

    @PutMapping(value = "api/updateUsers/{userId}/{name}/{date}/{email}")
    public String update (@PathVariable("userId")String userId,
                          @PathVariable("name")String name,
                          @PathVariable("date")String date,
                          @PathVariable("email")String email)
    {
        UpdateUser command = new UpdateUser(UserId.of(userId),
                new Name(name),
                new Date(date),
                new Email(email));

        UpdateUserUseCase.Response userUpdated = executedUseCase(command);
        String string = "{"
                + "\"userId\":" + "\""+userUpdated.getResponse().identity()+"\""+ ","
                + "\"name\":" + "\""+userUpdated.getResponse().getName()+"\""+ ","
                + "\"date\":" + "\""+userUpdated.getResponse().getDate()+"\""+ ","
                + "\"email\":" + "\""+userUpdated.getResponse().getEmail().value()
                +"}";
        return string;

    }
    private UpdateUserUseCase.Response executedUseCase(UpdateUser command) {
        UpdateUserUseCase.Response events= UseCaseHandler.getInstance()
                .syncExecutor(updateUserUseCase, new RequestCommand<>(command))
                .orElseThrow();
        UpdateUserUseCase.Response UserUpdated = events;
        return (UpdateUserUseCase.Response)UserUpdated;
    }



    @GetMapping(value = "api/findUsers")
    public Iterable<UserData> listar(){ return (transformationUserUseCase.listar());
    }

    @DeleteMapping(value = "api/deleteUsers/{id}")
    public String delete(@PathVariable("id") String id){ return (transformationUserUseCase.delete(id)); }
}
