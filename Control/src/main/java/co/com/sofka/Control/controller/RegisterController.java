package co.com.sofka.Control.controller;

import co.com.sofka.Control.domain.commands.CreateRegister;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.value.EntryDate;
import co.com.sofka.Control.domain.value.RegisterId;
import co.com.sofka.Control.domain.value.UserId;
import co.com.sofka.Control.useCase.CreateRegisterUseCase;
import co.com.sofka.Control.useCase.TransformationRegisterUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RegisterController {

    @Autowired
    private CreateRegisterUseCase useCase;
    @Autowired
    private TransformationRegisterUseCase transformationRegisterUseCase;

    @PostMapping(value = "api/saveRegisters/{registerId}/{userId}/{entryDate}")
    public String save(@PathVariable("registerId")String registerId,
                       @PathVariable("userId")String userId,
                       @PathVariable("entryDate")String entryDate)
                       {
        var command = new CreateRegister(RegisterId.of(registerId), UserId.of(userId), new EntryDate(entryDate));
        CreateRegisterUseCase.Response registerCreated = executedUseCase(command);
        return (registerCreated.getResponse().getUserId().value()+
                " "+registerCreated.getResponse().getEntryDate().value());
    }

    private CreateRegisterUseCase.Response executedUseCase(CreateRegister command) {
      var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var RegisterCreated = events;
        return RegisterCreated;
    }
    @GetMapping(value = "api/findRegisters")
    public Iterable<RegisterData> listar(){ return (transformationRegisterUseCase.listar());
    }

    @DeleteMapping(value = "api/deleteRegisters/{id}")
    public String delete(@PathVariable("id") String id){ return (transformationRegisterUseCase.delete(id)); }


}
