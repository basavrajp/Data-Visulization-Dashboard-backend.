package com.io.project.dashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long end_year;
    private String citylng;
    private String citylat;
    private Number intensity;
    private String sector;
    private String topic;
    private String insight;
    private String swot;
    private String url;
    private String region;
    private String start_year;
    private String impact;
    private String added;
    private String published;
    private String city;
    private String country;
    private Number relevance;
    private String pestle;
    private String source;
    private String title;
    private Number likelihood;

    public Data(String added, String city, String citylat, String citylng, String country, Long end_year, String impact, String insight, Number intensity, Number likelihood, String pestle, String published, String region, Number relevance, String sector, String source, String start_year, String swot, String title, String topic, String url) {
        this.added = added;
        this.city = city;
        this.citylat = citylat;
        this.citylng = citylng;
        this.country = country;
        this.end_year = end_year;
        this.impact = impact;
        this.insight = insight;
        this.intensity = intensity;
        this.likelihood = likelihood;
        this.pestle = pestle;
        this.published = published;
        this.region = region;
        this.relevance = relevance;
        this.sector = sector;
        this.source = source;
        this.start_year = start_year;
        this.swot = swot;
        this.title = title;
        this.topic = topic;
        this.url = url;
    }


    public Data(){

    }

  public Long getEnd_year() {
      return end_year;
  }
  public void setEnd_year(Long end_year) {
      this.end_year = end_year;
  }
  public String getCitylng() {
      return citylng;
  }
  public void setCitylng(String citylng) {
      this.citylng = citylng;
  }
  public String getCitylat() {
      return citylat;
  }
  public void setCitylat(String citylat) {
      this.citylat = citylat;
  }
  public Number getIntensity() {
      return intensity;
  }
  public void setIntensity(Number intensity) {
      this.intensity = intensity;
  }
  public String getSector() {
      return sector;
  }
  public void setSector(String sector) {
      this.sector = sector;
  }
  public String getTopic() {
      return topic;
  }
  public void setTopic(String topic) {
      this.topic = topic;
  }
  public String getInsight() {
      return insight;
  }
  public void setInsight(String insight) {
      this.insight = insight;
  }
  public String getSwot() {
      return swot;
  }
  public void setSwot(String swot) {
      this.swot = swot;
  }
  public String getUrl() {
      return url;
  }
  public void setUrl(String url) {
      this.url = url;
  }
  public String getRegion() {
      return region;
  }
  public void setRegion(String region) {
      this.region = region;
  }
  public String getStart_year() {
      return start_year;
  }
  public void setStart_year(String start_year) {
      this.start_year = start_year;
  }
  public String getImpact() {
      return impact;
  }
  public void setImpact(String impact) {
      this.impact = impact;
  }
  public String getAdded() {
      return added;
  }
  public void setAdded(String added) {
      this.added = added;
  }
  public String getPublished() {
      return published;
  }
  public void setPublished(String published) {
      this.published = published;
  }
  public String getCity() {
      return city;
  }
  public void setCity(String city) {
      this.city = city;
  }
  public String getCountry() {
      return country;
  }
  public void setCountry(String country) {
      this.country = country;
  }
  public Number getRelevance() {
      return relevance;
  }
  public void setRelevance(Number relevance) {
      this.relevance = relevance;
  }
  public String getPestle() {
      return pestle;
  }
  public void setPestle(String pestle) {
      this.pestle = pestle;
  }
  public String getSource() {
      return source;
  }
  public void setSource(String source) {
      this.source = source;
  }
  public String getTitle() {
      return title;
  }
  public void setTitle(String title) {
      this.title = title;
  }
  public Number getLikelihood() {
      return likelihood;
  }
  public void setLikelihood(Number likelihood) {
      this.likelihood = likelihood;
  }
    
  }


