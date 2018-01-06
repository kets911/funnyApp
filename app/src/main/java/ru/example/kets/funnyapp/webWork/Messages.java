        package ru.example.kets.funnyapp.webWork;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;

        public class Messages {

            private List<Messages> messages;

            public Messages(List<Messages> messages){
                this.messages = messages;
            }

    @SerializedName("topic")
    @Expose
    private Integer topic;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("message_id")
    @Expose
    private Integer messageId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("time")
    @Expose
    private Integer time;

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Messages message : messages){
                    sb.append("Title: ");
                    sb.append(message.getTitle());
                    sb.append("\n");
                    sb.append("Text: ");
                    sb.append(message.getText());
                    sb.append("\n");
                }
                return sb.toString();
            }
        }