package mishkat.mdrd.com.mishkat.DeskBoardsPages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class VendorDetailModel {


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
        @SerializedName("categories")
        private List<CategoriesEntity> categories;
        @Expose
        @SerializedName("socila_media")
        private List<Socila_mediaEntity> socila_media;
        @Expose
        @SerializedName("rate")
        private String rate;
        @Expose
        @SerializedName("favorite_id")
        private String favorite_id;
        @Expose
        @SerializedName("is_favorite")
        private boolean is_favorite;
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

        public List<CategoriesEntity> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesEntity> categories) {
            this.categories = categories;
        }

        public List<Socila_mediaEntity> getSocila_media() {
            return socila_media;
        }

        public void setSocila_media(List<Socila_mediaEntity> socila_media) {
            this.socila_media = socila_media;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getFavorite_id() {
            return favorite_id;
        }

        public void setFavorite_id(String favorite_id) {
            this.favorite_id = favorite_id;
        }

        public boolean getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(boolean is_favorite) {
            this.is_favorite = is_favorite;
        }

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

    public static class CategoriesEntity {
        @Expose
        @SerializedName("image")
        private String image;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("cat_id")
        private String cat_id;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }
    }

    public static class Socila_mediaEntity {
        @Expose
        @SerializedName("link")
        private String link;
        @Expose
        @SerializedName("name")
        private String name;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
