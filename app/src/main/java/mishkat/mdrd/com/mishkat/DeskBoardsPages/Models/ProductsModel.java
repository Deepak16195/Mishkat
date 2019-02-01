package mishkat.mdrd.com.mishkat.DeskBoardsPages.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ProductsModel {


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
        @SerializedName("rate")
        private int rate;
        @Expose
        @SerializedName("image")
        private String image;
        @Expose
        @SerializedName("discount_type")
        private String discount_type;
        @Expose
        @SerializedName("discount")
        private String discount;
        @Expose
        @SerializedName("has_discount")
        private boolean has_discount;
        @Expose
        @SerializedName("last_price")
        private String last_price;
        @Expose
        @SerializedName("price")
        private String price;
        @Expose
        @SerializedName("desc")
        private String desc;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("product_id")
        private String product_id;

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDiscount_type() {
            return discount_type;
        }

        public void setDiscount_type(String discount_type) {
            this.discount_type = discount_type;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public boolean getHas_discount() {
            return has_discount;
        }

        public void setHas_discount(boolean has_discount) {
            this.has_discount = has_discount;
        }

        public String getLast_price() {
            return last_price;
        }

        public void setLast_price(String last_price) {
            this.last_price = last_price;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }
    }
}
