package baseUtils.oneC;

public class ChatService {
    public String MessageID;
    public String TaskID;
    public String UserID;
    public String UserName;
    public String Message;
    public String CreatedAt;

    public ChatService(String messageID, String taskID, String userID, String userName, String message, String createdAt) {
        MessageID = messageID;
        TaskID = taskID;
        UserID = userID;
        UserName = userName;
        Message = message;
        CreatedAt = createdAt;
    }
}
