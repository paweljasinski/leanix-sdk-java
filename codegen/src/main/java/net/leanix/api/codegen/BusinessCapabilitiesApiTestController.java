package net.leanix.api.codegen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BusinessCapabilitiesApiTestController extends BaseApiFactSheetTestController
{
    public Map<String, Object> getPropertiesServiceHasBusinessCapabilities()
    {
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        result.put("attributes",Arrays.asList(
        		new TestAttribute("IsLeading", new Boolean(true), new Boolean(true))
        ));	

        return result;
    }  
}