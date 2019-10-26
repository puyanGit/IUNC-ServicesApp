package iucnCaller;

import iucnObj.region.CmRegion;
import iucnObj.spices.CmSpecies;

import java.io.IOException;

public class IuncSpicesCall extends IuncApiCallHelper<CmSpecies> {


    private static final String ADD_TO_URL= "species/region/";

    public IuncSpicesCall(Class<CmSpecies> resultTypeClass){
        super(resultTypeClass);
    }


    public CmSpecies executeCall(String region)
            throws ResourceServerException, IOException, ProblemWithHttpsException {

        String addToSpicesUrl = ADD_TO_URL + region + "/page/1";
        return makeHttpRequest(addToSpicesUrl);
    }


}
