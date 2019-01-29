package mishkat.mdrd.com.mishkat.api;


import mishkat.mdrd.com.mishkat.DeskBoardsPages.CatsModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.VendorDetailModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.AreasModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.LoginModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SignupModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SplashModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.VerifyModel;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface WebService {

    @POST("splash-screen")
    Observable<SplashModel> Getsplash();

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
    Observable<VendorDetailModel> GetVendorDetails(@Query("vendor_id") String lang);

    @POST("areas")
    Observable<AreasModel> GetAreas();


}
