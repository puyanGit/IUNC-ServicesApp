package iucnCaller;

import iucnObj.mammal.CmMammal;
import iucnObj.spices.CmSpecies;

import java.io.IOException;

public class IuncMammalCall extends IuncApiCallHelper<CmMammal> {


    private static final String ADD_TO_URL= "comp-group/getspecies/mammals";

    public IuncMammalCall(Class<CmMammal> resultTypeClass){
        super(resultTypeClass);
    }


    public CmMammal executeCall()
            throws ResourceServerException, IOException, ProblemWithHttpsException {

        return makeHttpRequest(ADD_TO_URL);
    }


}
