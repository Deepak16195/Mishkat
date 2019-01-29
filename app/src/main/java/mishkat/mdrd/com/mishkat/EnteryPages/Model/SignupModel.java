package mishkat.mdrd.com.mishkat.EnteryPages.Model;


public  class SignupModel {


    /**
     * status : true
     * message : success
     * result : {"code":"9834","mobile":"88987135665"}
     * errors :
     */

    private boolean status;
    private String message;
    private ResultBean result;
    private String errors;

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

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public static class ResultBean {
        /**
         * code : 9834
         * mobile : 88987135665
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
}
