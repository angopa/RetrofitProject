package com.organicfarmer.paezand.retrofitproject.data.model;

import com.google.gson.annotations.SerializedName;
import com.organicfarmer.paezand.retrofitproject.data.api.Validatable;

import java.util.List;

public class Pixabay implements Validatable {

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

    @Override
    public boolean isValid() {
        for (Hit hit: hits) {
            if (!hit.isValid()) return false;
        }
        return true;
    }
}
