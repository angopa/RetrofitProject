package com.organicfarmer.paezand.retrofitproject.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pixabay {

    @SerializedName("total")

    private Integer total;
    @SerializedName("totalHits")

    private Integer totalHits;
    @SerializedName("hits")

    private List<Hit> hits = null;

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }
}
