package com.example.bokjirock.LocationSearch;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Searcher {
    public static final String DAUM_MAPS_LOCAL_KEYWORD_SEARCH_API_FORMAT = "https://dapi.kakao.com/v2/local/search/keyword.json?query=%s&y=%s&x=%s&radius=%d&page=%d&apikey=%s";
    public static final String key_kakao = "abc92859a2d2a85b17ff431d03d60c31";  //REST API key

    private static final String HEADER_NAME_X_APPID = "x-appid";
    private static final String HEADER_NAME_X_PLATFORM = "x-platform";
    private static final String HEADER_VALUE_X_PLATFORM_ANDROID = "android";

    OnFinishListener onFinishListener;
    SearchTask searchTask;
    String appId;

    private class SearchTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... urls) {
            String url = urls[0];
            Map<String, String> header = new HashMap<String, String>();
            header.put(HEADER_NAME_X_APPID, appId);
            header.put(HEADER_NAME_X_PLATFORM, HEADER_VALUE_X_PLATFORM_ANDROID);
            String json = fetchData(url, header);
            List<PlaceItem> placeItemList = parse(json);
            if (onFinishListener != null) {
                if (placeItemList == null) {
                    onFinishListener.onFail();
                } else {
                    onFinishListener.onSuccess(placeItemList);
                }
            }
            return null;
        }
    }

    public void searchKeyword(Context applicationContext, String query, double latitude, double longitude, int radius, int page, String apikey, OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
        if (searchTask != null) {
            searchTask.cancel(true);
            searchTask = null;
        }
        String url = buildKeywordSearchApiUrlString(query, latitude, longitude, radius, page, apikey);
        searchTask = new SearchTask();
        searchTask.execute(url);
    }

    //UTF-8로 키워드 인코딩 필요.
    private String buildKeywordSearchApiUrlString(String query, double latitude, double longitude, int radius, int page, String apikey) {
        String encodedQuery = "";
        try {
            encodedQuery = URLEncoder.encode(query, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format(Locale.ENGLISH, DAUM_MAPS_LOCAL_KEYWORD_SEARCH_API_FORMAT, encodedQuery, latitude, longitude, radius, page, apikey);
    }

    //API 호출을 위한 메서드
    private String fetchData(String urlString, Map<String, String> header) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(4000 /* milliseconds */);
            conn.setConnectTimeout(7000 /* milliseconds */);
            conn.setRequestMethod("GET"); // GET 방식으로  API 요청
            conn.setRequestProperty("Authorization", "KakaoAK "+ key_kakao); // header 부분에 앱키 작성
            conn.setDoInput(true);
            conn.connect();

            InputStream is = conn.getInputStream();
            @SuppressWarnings("resource")
            Scanner s = new Scanner(is);
            s.useDelimiter("\\A");
            String data = s.hasNext() ? s.next() : "";

            Log.w("data : ", data);

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<PlaceItem> parse(String jsonString) {
        List<PlaceItem> PlaceItemList = new ArrayList<PlaceItem>();
        try {
            JSONObject reader = new JSONObject(jsonString);
            JSONArray objects = reader.getJSONArray("documents");
            for (int i = 0; i < objects.length(); i++) {
                JSONObject object = objects.getJSONObject(i);
                PlaceItem placeItem = new PlaceItem();
                placeItem.place_name = object.getString("place_name");
//                placeItem.place_url = object.getString("palce_url");
                placeItem.category_name = object.getString("category_name");
                placeItem.category_group_code = object.getString("category_group_code");
                placeItem.category_group_name = object.getString("category_group_name");
                placeItem.phone = object.getString("phone");
                placeItem.address_name = object.getString("address_name");
                placeItem.road_address_name = object.getString("road_address_name");
                placeItem.x = Double.parseDouble(object.getString("x"));
                placeItem.y = Double.parseDouble(object.getString("y"));
                placeItem.place_url = object.getString("place_url");
                placeItem.distance = Double.parseDouble(object.getString("distance"));
                PlaceItemList.add(placeItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return PlaceItemList;
    }

    public void cancel() {
        if (searchTask != null) {
            searchTask.cancel(true);
            searchTask = null;
        }
    }
}
