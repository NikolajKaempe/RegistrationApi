import org.junit.Assert;
import org.junit.Test;
import soap_services.countryDetails.webservicex.Country;
import soap_services.countryDetails.webservicex.CountrySoap;
import soap_services.geoIP.webservicex.GeoIP;
import soap_services.geoIP.webservicex.GeoIPService;
import soap_services.geoIP.webservicex.GeoIPServiceSoap;

/**
 * Created by Kaempe on 08-05-2017.
 */
public class geo_service_test
{

    @Test
    public void testGeoServiceTest()
    {
        //Arrange
        GeoIPService service = new GeoIPService();
        GeoIPServiceSoap temp = service.getGeoIPServiceSoap();

        System.out.println(service);
        System.out.println(temp);
        //Act
        GeoIP result = temp.getGeoIP("212.112.150.59");

        // assert
        System.out.println("ip = " + result.getIP());
        System.out.println("ISO = " + result.getCountryName());
        Assert.assertEquals("Denmark",result.getCountryName());
    }

    @Test
    public void testCountryDetails()
    {
        //Arrange
        Country service = new Country();
        CountrySoap temp = service.getCountrySoap();

        //Act
        String countries = temp.getCurrencyByCountry("Denmark");

        String[] currency = countries.split("<CurrencyCode>",3);
        String[] result = currency[1].split("</CurrencyCode>",3);

        // assert
        Assert.assertEquals("DKK",result[0]);
    }
}
