package com.example.bokjirock;

import androidx.appcompat.app.AppCompatActivity;

public class policyInfo extends AppCompatActivity {
    private String pTitle;
    private String pContent;
    private String pLikeCount;
    private String pCommentCount;
    private String id;

    public policyInfo(){

    }

    public policyInfo(String pTitle, String pContent, String pLikeCount, String pCommentCount, String pid) {
        this.setpTitle(pTitle);
        this.setpContent(pContent);
        this.setpLikeCount(pLikeCount);
        this.setpCommentCount(pCommentCount);
        this.setId(pid);
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpLikeCount() {
        return pLikeCount;
    }

    public void setpLikeCount(String pLikeCount) {
        this.pLikeCount = pLikeCount;
    }

    public String getpCommentCount() {
        return pCommentCount;
    }

    public void setpCommentCount(String pCommentCount) {
        this.pCommentCount = pCommentCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}