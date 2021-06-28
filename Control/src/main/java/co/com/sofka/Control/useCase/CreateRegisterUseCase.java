package co.com.sofka.Control.useCase;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.commands.CreateRegister;
import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRegisterUseCase extends UseCase<RequestCommand<CreateRegister>, CreateRegisterUseCase.Response> {

    @Autowired
    private IRegisterDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreateRegister> createRegisterRequestCommand) {
        var command = createRegisterRequestCommand.getCommand();
        var register = new Register(command.registerId(), command.userId(), command.entryDate());
        data.save(transform(register));
        emit().onResponse(new Response(register));
    }

    public RegisterData transform(Register register){
        RegisterData registerData = new RegisterData(register.getIdRegister(), register.getUserId().value(), register.getEntryDate().value());
        return registerData;
    }

    public static class Response implements UseCase.ResponseValues{

        private Register response;

        public Response(Register register) {
            this.response=register;
        }

        public Register getResponse() {
            return response;
        }

        public void setResponse(Register response) {
            this.response = response;
        }
    }

}
