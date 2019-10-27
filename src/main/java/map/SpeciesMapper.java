package map;

import iucnCaller.ProblemWithHttpsException;
import iucnCaller.ResourceServerException;
import iucnObj.region.CmRegion;
import iucnObj.region.CmRegionResult;
import iucnObj.spices.CmSpeciesResult;
import model.Species;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpeciesMapper
{


    /**
     *  map response object to model object
     *
     * @param cmSpeciesResults
     *             species result
     * @return list of species
     */
    public List<Species> getListOfSpeciesObject (CmSpeciesResult [] cmSpeciesResults) {
        List<Species> speciesList = new ArrayList<>();
        for (CmSpeciesResult cmSpeciesResultObj : cmSpeciesResults) {
            Species speciesObj = mapSimpleFields(cmSpeciesResultObj);
            speciesList.add(speciesObj);
        }
        return speciesList;
    }


    private Species mapSimpleFields (CmSpeciesResult cmSpeciesResultObj) {
        if (cmSpeciesResultObj == null)
            return null;
        Species speciesObj = new Species();

        speciesObj.setClass_name(cmSpeciesResultObj.getClass_name());
        speciesObj.setFamily_name(cmSpeciesResultObj.getFamily_name());
        speciesObj.setGenus_name(cmSpeciesResultObj.getGenus_name());
        speciesObj.setId(cmSpeciesResultObj.getTaxonid());
        speciesObj.setCategory(cmSpeciesResultObj.getCategory());
        speciesObj.setInfra_name(cmSpeciesResultObj.getInfra_name());
        speciesObj.setInfra_rank(cmSpeciesResultObj.getInfra_rank());
        speciesObj.setKingdom_name(cmSpeciesResultObj.getKingdom_name());
        speciesObj.setOrder_name(cmSpeciesResultObj.getOrder_name());
        speciesObj.setPhylum_name(cmSpeciesResultObj.getPhylum_name());
        speciesObj.setPopulation(cmSpeciesResultObj.getPopulation());
        speciesObj.setScientific_name(cmSpeciesResultObj.getScientific_name());

        return speciesObj;
    }
}
