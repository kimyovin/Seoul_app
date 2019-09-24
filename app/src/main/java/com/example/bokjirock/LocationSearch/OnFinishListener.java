package com.example.bokjirock.LocationSearch;

import java.util.List;

public interface OnFinishListener {
    public void onSuccess(List<PlaceItem> itemList);
    public void onFail();
}
