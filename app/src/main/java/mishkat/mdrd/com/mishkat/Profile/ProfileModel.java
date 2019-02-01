package mishkat.mdrd.com.mishkat.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class ProfileModel {


    @Expose
    @SerializedName("errors")
    private ErrorsEntity errors;
    @Expose
    @SerializedName("result")
    private ResultEntity result;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public ErrorsEntity getErrors() {
        return errors;
    }

    public void setErrors(ErrorsEntity errors) {
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

    public static class ErrorsEntity {
    }

    public static class ResultEntity {
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("mobile")
        private String mobile;
        @Expose
        @SerializedName("l_name")
        private String l_name;
        @Expose
        @SerializedName("f_name")
        private String f_name;
        @Expose
        @SerializedName("id")
        private String id;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getL_name() {
            return l_name;
        }

        public void setL_name(String l_name) {
            this.l_name = l_name;
        }

        public String getF_name() {
            return f_name;
        }

        public void setF_name(String f_name) {
            this.f_name = f_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
