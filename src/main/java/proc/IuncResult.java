package proc;

import iucnObj.region.CmRegion;
import iucnObj.region.CmRegionResult;
import iucnObj.spices.CmSpecies;
import model.Species;
import shared.SpeciesCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IuncResult {



    /**
     *  list of Critical Endangered Specie by title
     *
     * @param regionIdent
     *          selected region identity
     *
     * @return String
     *          title as concatenated text
     */
    public String CriticalEndangeredSpeciesByTitle(String regionIdent) {
        String titleOfCriticalSpecies = null;
        List<Species> speciesList =  criticalEndangeredSpecies(getCmSpeciesObject(regionIdent));
        if (speciesList == null || speciesList.isEmpty())
            return titleOfCriticalSpecies = "There is not species for this region: " + regionIdent + ". Pls Try agian.";
        titleOfCriticalSpecies = ""
        for (Species species: speciesList) {
            titleOfCriticalSpecies += species.getGenus_name() + ", ";
        }
        return titleOfCriticalSpecies;
    }

    /**
     * random region
     *
     * @return  region-Identifier
     */
    public String randomIdentByRegion() {
        CmRegion cmResponseRegion = null;
        int randIndex= 0;
        String randomRegionIdent = null;

        cmResponseRegion = getCmRegionObject();
        if (cmResponseRegion == null)
            return null;

        int randomRegionIndex = (int) (Math.random() * cmResponseRegion.getCount());

        for (CmRegionResult regionResult: cmResponseRegion.getResults()){
            if (randomRegionIndex == randIndex)
                randomRegionIdent = regionResult.getIdentifier();
            randIndex++;
        }
        return randomRegionIdent;
    }

    /**
     *  list of Critical Endangered Specie by title
     *
     * @param cmSpecies
     *          selected species
     *
     * @return List<Species>
     *          list of critically species
     *
     */
    private List<Species> criticalEndangeredSpecies(CmSpecies cmSpecies) {
        Mapper mapper = new Mapper();
        List<Species> CriticalSpeciesList = new ArrayList<>();
        List<Species> speciesList = mapper.getListOfSpeciesObject(cmSpecies.getResult());
        if (speciesList == null || speciesList.isEmpty())
            return null;
        for (Species species: speciesList) {
            if (species.getCategory() != null && species.getCategory().equals(SpeciesCategory.CR))
                CriticalSpeciesList.add(species);
        }
        return CriticalSpeciesList;
    }


    /**
     *  get list of regions
     *
     * @return list of response object
     *
     * @throws IOException if no access to Resource
     */
    private CmRegion getCmRegionObject (){
        CmRegion cmResponseRegion = new CmRegion();
        try {
               cmResponseRegion = new iucnCaller.IuncRegionCall(CmRegion.class).executeCall();
               if (cmResponseRegion == null || cmResponseRegion.getResults() == null)
                   return null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  cmResponseRegion;
    }

    /**
     *  get species response object
     *
     * @param regionIdentifier
     *          selected identifier
     *
     * @return CmSpecies response object
     *
     * @throws IOException if no access to Resource
     */
    private CmSpecies getCmSpeciesObject (String regionIdentifier){
        CmSpecies cmSpecies = new CmSpecies();
        try {

            cmSpecies = new iucnCaller.IuncSpicesCall(CmSpecies.class).executeCall(regionIdentifier);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  cmSpecies;
    }


}
