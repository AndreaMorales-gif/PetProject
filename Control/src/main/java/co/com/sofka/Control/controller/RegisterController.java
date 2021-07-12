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
    private CreateRegisterUseCase createRegisterUseCase;
    @Autowired
    private TransformationRegisterUseCase transformationRegisterUseCase;

    @PostMapping(value = "api/saveRegisters/{registerId}/{userId}/{entryDate}")
    public String save(@PathVariable("registerId")String registerId,
                       @PathVariable("userId")String userId,
                       @PathVariable("entryDate")String entryDate)
                       {
                           CreateRegister command = new CreateRegister(RegisterId.of(registerId), UserId.of(userId),
                new EntryDate(entryDate));

        CreateRegisterUseCase.Response registerCreated = executedUseCase(command);
        String string = "{"
                + "\"registerId\":" + "\""+registerCreated.getResponse().identity()+"\""+ ","
                + "\"userId\":" + "\""+registerCreated.getResponse().getUserId()+"\""+ ","
                + "\"entryDate\":" + "\""+registerCreated.getResponse().getEntryDate().value()
                +"}";
        return string;
    }

    private CreateRegisterUseCase.Response executedUseCase(CreateRegister command) {
        CreateRegisterUseCase.Response events= UseCaseHandler.getInstance()
                .syncExecutor(createRegisterUseCase, new RequestCommand<>(command))
                .orElseThrow();
        CreateRegisterUseCase.Response RegisterCreated = events;
        return RegisterCreated;
    }


    @GetMapping(value = "api/findRegisters")
    public Iterable<RegisterData> listar(){ return (transformationRegisterUseCase.listar());
    }

    @GetMapping(value = "api/findRegister/{id}")
    public RegisterData listarId(@PathVariable("id") String id){
        return (transformationRegisterUseCase.listarId(id));
    }


    @GetMapping(value = "api/validarIngreso/{id}")
    public String validar(@PathVariable("id") String id){ return (transformationRegisterUseCase.validarIngreso(id)); }


    @DeleteMapping(value = "api/deleteRegisters/{id}")
    public String delete(@PathVariable("id") String id){ return (transformationRegisterUseCase.delete(id)); }

}
