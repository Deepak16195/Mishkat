package mishkat.mdrd.com.mishkat.Address.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class SaveAddressModel {


    @Expose
    @SerializedName("errors")
    private ErrorsEntity errors;
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
}
