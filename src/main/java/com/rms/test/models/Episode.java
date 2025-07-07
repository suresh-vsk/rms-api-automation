package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Episode {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("live")
    private Boolean live;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("images")
    private Images images;
    
    @JsonProperty("labels")
    private Labels labels;
    
    @JsonProperty("signed")
    private Boolean signed;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("tleo_id")
    private String tleoId;
    
    @JsonProperty("guidance")
    private Boolean guidance;
    
    @JsonProperty("subtitle")
    private String subtitle;
    
    @JsonProperty("synopses")
    private Synopses synopses;
    
    @JsonProperty("versions")
    private List<Version> versions;
    
    @JsonProperty("childrens")
    private Boolean childrens;
    
    @JsonProperty("parent_id")
    private String parentId;
    
    @JsonProperty("tleo_type")
    private String tleoType;
    
    @JsonProperty("categories")
    private List<String> categories;
    
    @JsonProperty("has_credits")
    private Boolean hasCredits;
    
    @JsonProperty("requires_ab")
    private List<String> requiresAb;
    
    @JsonProperty("master_brand")
    private MasterBrand masterBrand;
    
    @JsonProperty("release_date")
    private String releaseDate;
    
    @JsonProperty("related_links")
    private List<Object> relatedLinks;
    
    @JsonProperty("original_title")
    private String originalTitle;
    
    @JsonProperty("programme_type")
    private String programmeType;
    
    @JsonProperty("audio_described")
    private Boolean audioDescribed;
    
    @JsonProperty("requires_sign_in")
    private Boolean requiresSignIn;
    
    @JsonProperty("release_date_time")
    private String releaseDateTime;
    
    @JsonProperty("lexical_sort_letter")
    private String lexicalSortLetter;
    
    @JsonProperty("requires_tv_licence")
    private Boolean requiresTvLicence;
    
    @JsonProperty("slice_subtitle")
    private String sliceSubtitle;
    
    @JsonProperty("parent_position")
    private Integer parentPosition;
    
    @JsonProperty("editorial_subtitle")
    private String editorialSubtitle;
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Boolean getLive() {
        return live;
    }
    
    public void setLive(Boolean live) {
        this.live = live;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Images getImages() {
        return images;
    }
    
    public void setImages(Images images) {
        this.images = images;
    }
    
    public Labels getLabels() {
        return labels;
    }
    
    public void setLabels(Labels labels) {
        this.labels = labels;
    }
    
    public Boolean getSigned() {
        return signed;
    }
    
    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTleoId() {
        return tleoId;
    }
    
    public void setTleoId(String tleoId) {
        this.tleoId = tleoId;
    }
    
    public Boolean getGuidance() {
        return guidance;
    }
    
    public void setGuidance(Boolean guidance) {
        this.guidance = guidance;
    }
    
    public String getSubtitle() {
        return subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    
    public Synopses getSynopses() {
        return synopses;
    }
    
    public void setSynopses(Synopses synopses) {
        this.synopses = synopses;
    }
    
    public List<Version> getVersions() {
        return versions;
    }
    
    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }
    
    public Boolean getChildrens() {
        return childrens;
    }
    
    public void setChildrens(Boolean childrens) {
        this.childrens = childrens;
    }
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public String getTleoType() {
        return tleoType;
    }
    
    public void setTleoType(String tleoType) {
        this.tleoType = tleoType;
    }
    
    public List<String> getCategories() {
        return categories;
    }
    
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
    public Boolean getHasCredits() {
        return hasCredits;
    }
    
    public void setHasCredits(Boolean hasCredits) {
        this.hasCredits = hasCredits;
    }
    
    public List<String> getRequiresAb() {
        return requiresAb;
    }
    
    public void setRequiresAb(List<String> requiresAb) {
        this.requiresAb = requiresAb;
    }
    
    public MasterBrand getMasterBrand() {
        return masterBrand;
    }
    
    public void setMasterBrand(MasterBrand masterBrand) {
        this.masterBrand = masterBrand;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public List<Object> getRelatedLinks() {
        return relatedLinks;
    }
    
    public void setRelatedLinks(List<Object> relatedLinks) {
        this.relatedLinks = relatedLinks;
    }
    
    public String getOriginalTitle() {
        return originalTitle;
    }
    
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    
    public String getProgrammeType() {
        return programmeType;
    }
    
    public void setProgrammeType(String programmeType) {
        this.programmeType = programmeType;
    }
    
    public Boolean getAudioDescribed() {
        return audioDescribed;
    }
    
    public void setAudioDescribed(Boolean audioDescribed) {
        this.audioDescribed = audioDescribed;
    }
    
    public Boolean getRequiresSignIn() {
        return requiresSignIn;
    }
    
    public void setRequiresSignIn(Boolean requiresSignIn) {
        this.requiresSignIn = requiresSignIn;
    }
    
    public String getReleaseDateTime() {
        return releaseDateTime;
    }
    
    public void setReleaseDateTime(String releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }
    
    public String getLexicalSortLetter() {
        return lexicalSortLetter;
    }
    
    public void setLexicalSortLetter(String lexicalSortLetter) {
        this.lexicalSortLetter = lexicalSortLetter;
    }
    
    public Boolean getRequiresTvLicence() {
        return requiresTvLicence;
    }
    
    public void setRequiresTvLicence(Boolean requiresTvLicence) {
        this.requiresTvLicence = requiresTvLicence;
    }
    
    public String getSliceSubtitle() {
        return sliceSubtitle;
    }
    
    public void setSliceSubtitle(String sliceSubtitle) {
        this.sliceSubtitle = sliceSubtitle;
    }
    
    public Integer getParentPosition() {
        return parentPosition;
    }
    
    public void setParentPosition(Integer parentPosition) {
        this.parentPosition = parentPosition;
    }
    
    public String getEditorialSubtitle() {
        return editorialSubtitle;
    }
    
    public void setEditorialSubtitle(String editorialSubtitle) {
        this.editorialSubtitle = editorialSubtitle;
    }
}