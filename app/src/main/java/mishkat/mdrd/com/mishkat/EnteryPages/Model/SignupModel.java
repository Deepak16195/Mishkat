package mishkat.mdrd.com.mishkat.EnteryPages.Model;


public  class SignupModel {


    /**
     * status : true
     * message : success
     * result : {"code":"2221","mobile":"79778057622"}
     * errors : {"mobile":"the mobile is already exist","email":"the email is already exist"}
     */

    private boolean status;
    private String message;
    private ResultBean result;
    private ErrorsBean errors;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public ErrorsBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorsBean errors) {
        this.errors = errors;
    }

    public static class ResultBean {
        /**
         * code : 2221
         * mobile : 79778057622
         */

        private String code;
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

    public static class ErrorsBean {
        /**
         * mobile : the mobile is already exist
         * email : the email is already exist
         */

        private String mobile;
        private String email;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
