package mishkat.mdrd.com.mishkat.EnteryPages.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class LoginModel {


    @Expose
    @SerializedName("errors")
    private String errors;
    @Expose
    @SerializedName("result")
    private ResultEntity result;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

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
        @SerializedName("code")
        private String code;
        @Expose
        @SerializedName("mobile")
        private String mobile;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
