package utility.API;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Utilities {

    public static Faker faker = new Faker();
    public static String authToken;
    public static String userToken;
    public static String userID;
    public static String userEmail;
    public static String projectDb_Id;
    public static String projectCreatedAt;
    public static String pencereDbId;
    public static String kapiDbId;
    public static String kolonDbId;
    public static String pencereCreated;
    public static String kapiCreated;
    public static String kolonCreated;

    public static final String manuellPassword = "admin";

    public static final String callOwnAccountUrl = "https://stg.mobilyaplan.app/webapi/user/myself";
    public static final String createNewAccountUrl = "https://stg.mobilyaplan.app/webapi/user";
    public static final String createNewProjectUrl = "https://stg.mobilyaplan.app/webapi/project";
    public static final String signInUrl = "https://stg.mobilyaplan.app/webapi/login/sign-in";

    static String loginUrl = "https://stg.mobilyaplan.app/webapi/login/sign-in";

//    public static String getAuthorisedToken() {
//
//        Map<String, String> body = new HashMap<>();
//        body.put("email", USERCREDENTIAL.USER_API.getUsername());
//        body.put("password", USERCREDENTIAL.USER_API.getPassword());
//
//       Response response =
//                given()
//                        .contentType(ContentType.JSON)
//                        .body(body)
//                        .when()
//                        .post(loginUrl);
//         authToken = response.getCookie("token");
//        return authToken;
//
//    }

    public static String getNewAccountToken() {

        Map<String, String> body = new HashMap<>();
        body.put("email", userEmail);
        body.put("password", manuellPassword); // otomatik atamada sikinti var. Manuel yazildi

       Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post(loginUrl);
         userToken = response.getCookie("token");
         return userToken;


    }

}
