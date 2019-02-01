package mishkat.mdrd.com.mishkat.Address.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class GetAddreessModel {


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
        @SerializedName("flat")
        private String flat;
        @Expose
        @SerializedName("floor")
        private String floor;
        @Expose
        @SerializedName("house")
        private String house;
        @Expose
        @SerializedName("street")
        private String street;
        @Expose
        @SerializedName("block")
        private String block;
        @Expose
        @SerializedName("area_name")
        private String area_name;
        @Expose
        @SerializedName("city_name")
        private String city_name;
        @Expose
        @SerializedName("area_id")
        private String area_id;
        @Expose
        @SerializedName("city_id")
        private String city_id;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("address_id")
        private String address_id;

        public String getFlat() {
            return flat;
        }

        public void setFlat(String flat) {
            this.flat = flat;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }
    }
}



