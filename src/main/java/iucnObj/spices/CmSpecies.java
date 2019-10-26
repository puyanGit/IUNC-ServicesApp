package iucnObj.spices;

import model.Species;

public class CmSpecies {

    private Integer count;
    private Integer page;
    private Species [] result;

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

    public Species[] getResult() {
        return result;
    }

    public void setResult(Species[] result) {
        this.result = result;
    }
}
