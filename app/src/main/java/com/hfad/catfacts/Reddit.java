package com.hfad.catfacts;

import java.lang.reflect.Array;
import java.util.List;

public class Reddit {
    private String modhash;
    private int dist;
    private List<RedditResponse> children;

    public Reddit(String modhash, int dist, List<RedditResponse> children) {

        this.modhash = modhash;
        this.dist = dist;
        this.children = children;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public List<RedditResponse> getChildren() {
        return children;
    }

    public void setChildren(List<RedditResponse> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Reddit{" +
                "modhash='" + modhash + '\'' +
                ", dist=" + dist +
                ", children=" + children +
                '}';
    }
}
