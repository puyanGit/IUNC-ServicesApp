package iucnCaller;

import iucnObj.region.CmRegion;

import java.io.IOException;

public class IuncRegionCall extends IuncApiCallHelper<CmRegion> {


    private static final String ADD_TO_URL= "region/list";

    public IuncRegionCall(Class<CmRegion> resultTypeClass){
        super(resultTypeClass);
    }


    public CmRegion executeCall()
            throws ResourceServerException, IOException, ProblemWithHttpsException {

        return makeHttpRequest(ADD_TO_URL);


    }


}
