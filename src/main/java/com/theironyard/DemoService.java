package com.theironyard;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.RefreshAccessTokenCredentials;
import com.wrapper.spotify.models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DemoService {

    public void refreshToken(Api api){
        try {
            RefreshAccessTokenCredentials refresh = api.refreshAccessToken().build().get();
            api.setAccessToken(refresh.getAccessToken());

        } catch (IOException | WebApiException e) {
            e.printStackTrace();
        }
    }

    public User getUser(Api api) {
        User user = null;

        try {
            user = api.getMe().build().get();
        } catch (IOException | WebApiException e) {
            e.printStackTrace();
        }

        return user;
    }
}
