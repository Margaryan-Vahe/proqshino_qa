package baseUtils.oneC;

import java.util.List;

public class BatchMessageResponse {
    public List<ChatService> BatchMessage;

    public BatchMessageResponse() { }

    public BatchMessageResponse(List<ChatService> batchMessage) {
        this.BatchMessage = batchMessage;
    }
}
