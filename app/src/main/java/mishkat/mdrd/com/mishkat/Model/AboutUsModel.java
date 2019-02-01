package mishkat.mdrd.com.mishkat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class AboutUsModel {


    @Expose
    @SerializedName("result")
    private ResultEntity result;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class ResultEntity {
        @Expose
        @SerializedName("content")
        private String content;
        @Expose
        @SerializedName("title")
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
