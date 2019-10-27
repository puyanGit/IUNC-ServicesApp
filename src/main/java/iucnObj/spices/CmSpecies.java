package iucnObj.spices;

import model.Species;

public class CmSpecies {

    private Integer count;
    private Integer page;
    private CmSpeciesResult [] result;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public CmSpeciesResult[] getResult() {
        return result;
    }

    public void setResult(CmSpeciesResult[] result) {
        this.result = result;
    }
}
