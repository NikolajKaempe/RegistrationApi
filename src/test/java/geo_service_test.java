import org.junit.Assert;
import org.junit.Test;
import soap_services.geoIPservice.webservicex.GeoIP;
import soap_services.geoIPservice.webservicex.GeoIPService;
import soap_services.geoIPservice.webservicex.GeoIPServiceSoap;

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
        GeoIP result = temp.getGeoIP("192.18.125.144");

        // assert
        System.out.println("ip = " + result.getIP());
        System.out.println("ISO = " + result.getCountryCode());
        Assert.assertEquals("DNK",result.getCountryCode());
    }
}
