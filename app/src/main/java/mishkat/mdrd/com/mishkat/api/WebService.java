package mishkat.mdrd.com.mishkat.api;


import mishkat.mdrd.com.mishkat.Address.Model.GetAddreessModel;
import mishkat.mdrd.com.mishkat.Address.Model.MyAddressModel;
import mishkat.mdrd.com.mishkat.Address.Model.SaveAddressModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.CatsModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.ProductsModel;
import mishkat.mdrd.com.mishkat.Model.AboutUsModel;
import mishkat.mdrd.com.mishkat.Model.ContectModel;
import mishkat.mdrd.com.mishkat.Profile.ProfileModel;
import mishkat.mdrd.com.mishkat.SearchVanders.Models.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.VendorDetailModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.AdsModel;
import mishkat.mdrd.com.mishkat.SearchVanders.Models.AreasModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.LoginModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SignupModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SplashModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.VerifyModel;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface WebService {

    @POST("splash-screen")
    Observable<SplashModel> Getsplash();

    @POST("ads")
    Observable<AdsModel> GetAds();


    @POST("register")
    Observable<SignupModel> SaveRegister(@Query("lang") String lang,
                                         @Query("f_name") String f_name,
                                         @Query("l_name") String l_name,
                                         @Query("mobile") String mobile,
                                         @Query("email") String email);

    @POST("verify-code")
    Observable<VerifyModel> VerifyRegister(@Query("mobile") String mobile,
                                           @Query("code") String code,
                                           @Query("device_id") String device_id);

    @POST("login")
    Observable<LoginModel> LoginUser(@Query("lang") String lang,
                                     @Query("mobile") String mobile);


    @POST("vendors-cats")
    Observable<CatsModel> Getcats();

    @POST("vendors")
    Observable<GetAllVenderModel> GetAllVender();

    @POST("vendor-details")
    Observable<VendorDetailModel> GetVendorDetails(@Query("vendor_id") String vendor_id);

    @POST("areas")
    Observable<AreasModel> GetAreas();

    @POST("products")
    Observable<ProductsModel> Getproducts();

    @POST("my-profile")
    Observable<ProfileModel> GetProfile(@Query("lang") String lang, @Query("customer_id") String customer_id);


    @POST("update-profile")
    Observable<ProfileModel> UpdateProfile(@Query("lang") String lang,
                                           @Query("customer_id") String customer_id,
                                           @Query("f_name") String f_name,
                                           @Query("l_name") String l_name,
                                           @Query("mobile") String mobile,
                                           @Query("email") String email);


    @POST("add-address")
    Observable<SaveAddressModel> AddAddress(@Query("lang") String lang,
                                            @Query("customer_id") String customer_id,
                                            @Query("title") String title,
                                            @Query("area") String area,
                                            @Query("block") String block,
                                            @Query("street") String street,
                                            @Query("house") String house,
                                            @Query("flat") String flat,
                                            @Query("apartment") String apartment,
                                            @Query("notes") String notes,
                                            @Query("city_id") String city_id,
                                            @Query("area_id") String area_id);


    @POST("my-address")
    Observable<MyAddressModel> GETMyAddress(@Query("customer_id") String customer_id);

    @POST("remove-address")
    Observable<MyAddressModel> Remove_Address(@Query("customer_id") String customer_id, @Query("address_id") String address_id);

    @POST("address-details")
    Observable<GetAddreessModel> Get_Address(@Query("customer_id") String customer_id, @Query("address_id") String address_id);

    @GET("about-us")
    Observable<AboutUsModel> Getaboutus();

    @GET("privacy-policy")
    Observable<AboutUsModel> Getprivacypolicy();


    @GET("terms-and-conditions")
    Observable<AboutUsModel> Gettermsandconditions();


    @POST("contact-us")
    Observable<ContectModel> ContactUs(@Query("lang") String lang,
                                       @Query("f_name") String f_name,
                                       @Query(" l_name") String l_name,
                                       @Query(" mobile") String mobile,
                                       @Query(" email") String email,
                                       @Query(" comment") String comment);


}
