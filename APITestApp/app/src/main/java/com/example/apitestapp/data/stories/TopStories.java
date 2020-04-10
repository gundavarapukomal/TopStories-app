
package com.example.apitestapp.data.stories;

import java.io.Serializable;
import java.util.List;

public class TopStories implements Serializable {


    private String status;

    private String copyright;

    private String section;

    private String lastUpdated;

    private Integer numResults;

    private List<TopResult> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<TopResult> getResults() {
        return results;
    }

    public void setResults(List<TopResult> results) {
        this.results = results;
    }

}
