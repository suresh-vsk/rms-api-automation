package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Images {
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("standard")
    private String standard;
    
    @JsonProperty("inherited_from")
    private String inheritedFrom;
    
    @JsonProperty("promotional")
    private String promotional;
    
    @JsonProperty("promotional_with_logo")
    private String promotionalWithLogo;
    
    // Getters and setters
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getStandard() {
        return standard;
    }
    
    public void setStandard(String standard) {
        this.standard = standard;
    }
    
    public String getInheritedFrom() {
        return inheritedFrom;
    }
    
    public void setInheritedFrom(String inheritedFrom) {
        this.inheritedFrom = inheritedFrom;
    }
    
    public String getPromotional() {
        return promotional;
    }
    
    public void setPromotional(String promotional) {
        this.promotional = promotional;
    }
    
    public String getPromotionalWithLogo() {
        return promotionalWithLogo;
    }
    
    public void setPromotionalWithLogo(String promotionalWithLogo) {
        this.promotionalWithLogo = promotionalWithLogo;
    }
}