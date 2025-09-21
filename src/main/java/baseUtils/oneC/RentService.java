package baseUtils.oneC;

public class RentService {
 public String Id;
 public String Updated;
 public String Number;
 public boolean Delete;
 public String Status;

    public RentService(String Id, String Updated, String Number, boolean Delete, String Status) {
        this.Id = Id;
        this.Updated = Updated;
        this.Number = Number;
        this.Delete = Delete;
        this.Status = Status;
    }
}
