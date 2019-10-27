package proc;

import iucnObj.mammal.CmMammal;
import iucnObj.region.CmRegion;
import iucnObj.region.CmRegionResult;
import iucnObj.spices.CmSpecies;
import map.MammalMapper;
import map.SpeciesMapper;
import model.Mammal;
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
    public String criticalEndangeredSpeciesByTitle(String regionIdent) {
        String titleOfCriticalSpecies = null;
        List<Species> speciesList =  criticalEndangeredSpecies(getCmSpeciesObject(regionIdent));
        if (speciesList == null || speciesList.isEmpty())
            return titleOfCriticalSpecies = "There is not species for this region: " + regionIdent + ". Pls Try agian.";
        titleOfCriticalSpecies = "Critical endangered species in the region " + regionIdent + ":\n";
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
     *  list of Critical Endangered mamals
     *
     *
     * @return String
     *          mammals as concatenated text
     */
    public String criticalEndangeredMammals() {
        String endangeredMammals = null;
        List<Mammal> mammalList =  criticalEndangeredMammals(getCmMammalObject ());
        if (mammalList == null || mammalList.isEmpty())
            return endangeredMammals = "There is not critically endangered mammals";
        endangeredMammals = "Critically endangered mammals:\n";
        for (Mammal mammal: mammalList) {
            endangeredMammals += mammal.getScientific_name() + ", ";
        }
        return endangeredMammals;
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
        SpeciesMapper speciesMapper = new SpeciesMapper();
        List<Species> CriticalSpeciesList = new ArrayList<>();
        List<Species> speciesList = speciesMapper.getListOfSpeciesObject(cmSpecies.getResult());
        if (speciesList == null || speciesList.isEmpty())
            return null;
        for (Species species: speciesList) {
            if (species.getCategory() != null && species.getCategory().equals(SpeciesCategory.CR))
                CriticalSpeciesList.add(species);
        }
        return CriticalSpeciesList;
    }


    /**
     *  list of Critical Endangered mammal
     *
     * @param cmMammal
     *          mammals
     *
     * @return List<Mammal>
     *          list of critically species
     *
     */
    private List<Mammal> criticalEndangeredMammals(CmMammal cmMammal) {
        MammalMapper mammalMapper = new MammalMapper();
        List<Mammal> CriticalEnndangerdmammals = new ArrayList<>();
        List<Mammal> mammalList = mammalMapper.getListOfSpeciesObject(cmMammal.getResult());
        if (mammalList == null || mammalList.isEmpty())
            return null;
        for (Mammal mammal: mammalList) {
            if (mammal.getCategory() != null && mammal.getCategory().equals(SpeciesCategory.CR))
                CriticalEnndangerdmammals.add(mammal);
        }
        return CriticalEnndangerdmammals;
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

    /**
     *  get list of mammals
     *
     * @return list of response object
     *
     * @throws IOException if no access to Resource
     */
    public CmMammal getCmMammalObject (){
        CmMammal cmResponseMammal = new CmMammal();
        try {
            cmResponseMammal = new iucnCaller.IuncMammalCall(CmMammal.class).executeCall();
            if (cmResponseMammal == null || cmResponseMammal.getResult() == null)
                return null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  cmResponseMammal;
    }


}
