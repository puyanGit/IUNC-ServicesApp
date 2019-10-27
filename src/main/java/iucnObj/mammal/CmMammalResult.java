package iucnObj.mammal;

import shared.SpeciesCategory;

public class CmMammalResult {

    private Integer taxonid;
    private String scientific_name;
    private String subspecies;
    private String rank;
    private String subpopulation;
    private SpeciesCategory category;

    public Integer getTaxonid() {
        return taxonid;
    }

    public void setTaxonid(Integer taxonid) {
        this.taxonid = taxonid;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSubpopulation() {
        return subpopulation;
    }

    public void setSubpopulation(String subpopulation) {
        this.subpopulation = subpopulation;
    }

    public SpeciesCategory getCategory() {
        return category;
    }

    public void setCategory(SpeciesCategory category) {
        this.category = category;
    }
}
