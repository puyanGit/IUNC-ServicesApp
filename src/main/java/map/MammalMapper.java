package map;

import iucnObj.mammal.CmMammalResult;
import iucnObj.spices.CmSpeciesResult;
import model.Mammal;
import model.Species;

import java.util.ArrayList;
import java.util.List;

public class MammalMapper
{


    /**
     *  map response object to model object
     *
     * @param cmMammalResults
     *             mammals result
     * @return list of mammal
     */
    public List<Mammal> getListOfSpeciesObject (CmMammalResult[] cmMammalResults) {
        List<Mammal> mammalList = new ArrayList<>();
        for (CmMammalResult cmMammalResultObj : cmMammalResults) {
            Mammal mammalObj = mapSimpleFields(cmMammalResultObj);
            mammalList.add(mammalObj);
        }
        return mammalList;
    }


    private Mammal mapSimpleFields (CmMammalResult cmMammalResultObj) {
        if (cmMammalResultObj == null)
            return null;
        Mammal mammalObj = new Mammal();

        mammalObj.setCategory(cmMammalResultObj.getCategory());
        mammalObj.setId(cmMammalResultObj.getTaxonid());
        mammalObj.setRank(cmMammalResultObj.getRank());
        mammalObj.setScientific_name(cmMammalResultObj.getScientific_name());
        mammalObj.setSubpopulation(cmMammalResultObj.getSubpopulation());
        mammalObj.setSubspecies(cmMammalResultObj.getSubspecies());

        return mammalObj;

    }
}
