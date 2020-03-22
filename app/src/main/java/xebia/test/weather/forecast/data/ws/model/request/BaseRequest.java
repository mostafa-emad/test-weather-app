package xebia.test.weather.forecast.data.ws.model.request;

import java.io.Serializable;

public class BaseRequest implements Serializable{
    private String UserID;
    private String AuthKey;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String authKey) {
        AuthKey = authKey;
    }
}
