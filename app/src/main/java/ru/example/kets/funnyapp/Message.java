package ru.example.kets.funnyapp;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        public class Message {

    @SerializedName("topic")
    @Expose
    private Integer topic;
    @SerializedName("title")
    @Expose
    private java.lang.String title;
    @SerializedName("text")
    @Expose
    private java.lang.String text;
    @SerializedName("message_id")
    @Expose
    private Integer messageId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user")
    @Expose
    private java.lang.String user;
    @SerializedName("time")
    @Expose
    private Integer time;

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getText() {
        return text;
    }

    public void setText(java.lang.String text) {
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

    public java.lang.String getUser() {
        return user;
    }

    public void setUser(java.lang.String user) {
        this.user = user;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

        }