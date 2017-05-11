package controllers;

import soap_services.countryDetails.webservicex.Country;
import soap_services.countryDetails.webservicex.CountrySoap;
import soap_services.geoIP.webservicex.GeoIP;
import soap_services.geoIP.webservicex.GeoIPService;
import soap_services.geoIP.webservicex.GeoIPServiceSoap;

import static jsonUtil.JsonUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;

/**
 * Created by Kaempe on 08-05-2017.
 */
public class RegistrationController
{
    public RegistrationController(){


        get("/currency", (req, res) ->
        {
            GeoIP ipResult = null;
            String countries;
            String[] currency;
            String[] result;
            try
            {
                GeoIPService ipService = new GeoIPService();
                GeoIPServiceSoap ipInterface = ipService.getGeoIPServiceSoap();
                Country countryService = new Country();
                CountrySoap countryInterface = countryService.getCountrySoap();

                String ip = req.ip();
                System.out.println(ip);
                ipResult = ipInterface.getGeoIP(ip);
                System.out.println(ipResult.getCountryName());
                countries = countryInterface.getCurrencyByCountry(ipResult.getCountryName());
                currency = countries.split("<CurrencyCode>",3);
                result = currency[1].split("</CurrencyCode>",3);
                if (result[0].length() > 0) return result[0];
            }catch (Exception e)
            {
                res.status(400);
                return new String ("Unable to access GeoIpService");
            }

            res.status(400);
            return new String ("Unable to get a respons from GeoIpService");
        }, json());

        get("/currency", (req, res) ->
        {
            GeoIP ipResult = null;
            String countries;
            String[] currency;
            String[] result;
            try
            {
                GeoIPService ipService = new GeoIPService();
                GeoIPServiceSoap ipInterface = ipService.getGeoIPServiceSoap();
                Country countryService = new Country();
                CountrySoap countryInterface = countryService.getCountrySoap();

                String ip = req.ip();
                System.out.println(ip);
                ipResult = ipInterface.getGeoIP(ip);
                System.out.println(ipResult.getCountryName());
                countries = countryInterface.getCurrencyByCountry(ipResult.getCountryName());
                currency = countries.split("<CurrencyCode>",3);
                result = currency[1].split("</CurrencyCode>",3);
                if (result[0].length() > 0) return result[0];
            }catch (Exception e)
            {
                res.status(400);
                return new String ("Unable to access GeoIpService");
            }

            res.status(400);
            return new String ("Unable to get a respons from GeoIpService");
        }, json());

        after((req, res) -> {
            res.type("application/json");
            res.header("responseServer","Server: 2");
        });
    }

}
