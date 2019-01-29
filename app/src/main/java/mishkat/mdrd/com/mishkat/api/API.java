package mishkat.mdrd.com.mishkat.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by Android Dev on 27-02-2018.
 */

public class API {
    public API() {
    }

    public static final String BASE_URL = "http://www.meshkatkw.com/api/";

    public static WebService getAPIService() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(1, TimeUnit.DAYS);
        okHttpClient.readTimeout(90, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(90, TimeUnit.SECONDS);
        return RetrofitClient.getClient(BASE_URL).create(WebService.class);


    }
}