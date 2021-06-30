package co.com.sofka.Control.useCase;



import co.com.sofka.Control.domain.User;
import co.com.sofka.Control.domain.commands.CreateUser;
import co.com.sofka.Control.domain.repository.IUserDataRepository;
import co.com.sofka.Control.domain.repository.UserData;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase extends UseCase<RequestCommand<CreateUser>, CreateUserUseCase.Response> {

    @Autowired
    private IUserDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<CreateUser> createUserRequestCommand) {
        var command = createUserRequestCommand.getCommand();
        var user = new User(command.UserId(), command.Name(), command.Date(), command.Email());
        data.save(transform(user));
        emit().onResponse(new Response(user));
    }

    public UserData transform(User user){
        UserData userData = new UserData(user.getIdUser(), user.getName().value(), user.getDate().value(),user.getEmail().value());
        return userData;
    }

    public static class Response implements UseCase.ResponseValues{

        private User response;

        public Response(User user) {
            this.response=user;
        }

        public User getResponse() {
            return response;
        }

        public void setResponse(User response) {
            this.response = response;
        }
    }
}
