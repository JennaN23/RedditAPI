package com.hfad.catfacts;

import java.util.List;

public class RedditResponse {
    private String kind;
    private Reddit data;

    public RedditResponse(){

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Reddit getData() {
        return data;
    }

    public void setData(Reddit data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RedditResponse{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
