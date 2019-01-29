package mishkat.mdrd.com.mishkat.DeskBoardsPages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class GetAllVenderModel {


    @Expose
    @SerializedName("result")
    private List<ResultEntity> result;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
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
        @SerializedName("logo")
        private String logo;
        @Expose
        @SerializedName("banner")
        private String banner;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("rate")
        private String rate;
        @Expose
        @SerializedName("delivery_time")
        private String delivery_time;
        @Expose
        @SerializedName("min_order")
        private String min_order;
        @Expose
        @SerializedName("open_status")
        private String open_status;
        @Expose
        @SerializedName("vendor_id")
        private String vendor_id;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public String getMin_order() {
            return min_order;
        }

        public void setMin_order(String min_order) {
            this.min_order = min_order;
        }

        public String getOpen_status() {
            return open_status;
        }

        public void setOpen_status(String open_status) {
            this.open_status = open_status;
        }

        public String getVendor_id() {
            return vendor_id;
        }

        public void setVendor_id(String vendor_id) {
            this.vendor_id = vendor_id;
        }
    }
}
