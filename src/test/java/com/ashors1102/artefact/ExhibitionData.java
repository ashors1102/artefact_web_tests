package com.ashors1102.artefact;

public class ExhibitionData {

    private final String shortName;
    private final String fullName;
    private final String brief;
    private final String city;

    public ExhibitionData (String shortName, String fullName, String brief, String city){
        this.shortName = shortName;
        this.fullName = fullName;
        this.brief = brief;
        this.city = city;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBrief() {
        return brief;
    }

    public String getCity() {
        return city;
    }
}
