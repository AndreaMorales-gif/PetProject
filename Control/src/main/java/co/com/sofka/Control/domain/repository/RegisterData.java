package co.com.sofka.Control.domain.repository;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RegisterAndrea")
public class RegisterData {

    @Id
    protected String id;
    protected String userId;
    protected String entryDate;

    public RegisterData(String id, String userId, String entryDate) {
        this.id = id;
        this.userId = userId;
        this.entryDate = entryDate;
    }

    public RegisterData(){
    }

    public String getId() { return id; }

    public void setId(String idRegister) { this.id = idRegister; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getEntryDate() { return entryDate; }

    public void setEntryDate(String entryDate) { this.entryDate = entryDate; }
}
