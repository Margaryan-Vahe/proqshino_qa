package baseUtils.mobApp;

public class CreateRequest {
    public String requestId;
    public String userId;
    public String placeId;
    public String createdAt;
    public String title;
    public String subject;
    public String status;
    public Boolean isUrgent;
    public Boolean sentToOneC;
    public String oneCNumber;
    public String photos;

    public CreateRequest(String requestId, String userId, String placeId, String createdAt,
                         String title, String subject, String status, Boolean isUrgent, Boolean sentToOneC,
                         String oneCNumber, String photos) {
        this.requestId = requestId;
        this.userId = userId;
        this.placeId = placeId;
        this.createdAt = createdAt;
        this.title = title;
        this.subject = subject;
        this.status = status;
        this.isUrgent = isUrgent;
        this.sentToOneC = sentToOneC;
        this.oneCNumber = oneCNumber;
        this.photos = photos;
    }
}
