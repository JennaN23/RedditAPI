package com.hfad.catfacts;

import java.util.List;

public class RedditResponse {
    private String kind;
    private List<Reddit> data;

    public RedditResponse(String kind, List<Reddit> data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Reddit> getData() {
        return data;
    }

    public void setData(List<Reddit> data) {
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
