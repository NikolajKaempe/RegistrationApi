package controllers;

import soap_services.geoIPservice.webservicex.GeoIP;
import soap_services.geoIPservice.webservicex.GeoIPService;
import soap_services.geoIPservice.webservicex.GeoIPServiceSoap;

import static jsonUtil.JsonUtil.json;
import static spark.Spark.get;

/**
 * Created by Kaempe on 08-05-2017.
 */
public class RegistrationController
{
    public RegistrationController(){


        get("/currency", (req, res) ->
        {
            GeoIPService service = new GeoIPService();
            GeoIPServiceSoap temp = service.getGeoIPServiceSoap();
            String ip = req.ip();
            System.out.println(ip);
            GeoIP result = temp.getGeoIP(ip);

            if (result != null ){
                res.status(200);
                return result.getCountryCode();
            }
            res.status(400);
            return new String ("Unable to access GeoIpService");
        }, json());
    }

}
