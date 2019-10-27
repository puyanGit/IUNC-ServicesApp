import iucnObj.region.CmRegion;
import iucnObj.region.CmRegionResult;
import iucnObj.spices.CmSpecies;
import proc.IuncResult;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class main {

    public static void main(String[] args) throws IOException {
        IuncResult iuncResult = new IuncResult();
        String region = iuncResult.randomIdentByRegion();
        System.out.println(iuncResult.criticalEndangeredSpeciesByTitle(region));
        System.out.println(iuncResult.criticalEndangeredMammals());


    }


}
