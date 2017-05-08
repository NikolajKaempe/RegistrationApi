import controllers.RegistrationController;

import static spark.Spark.port;

/**
 * Created by Kaempe on 08-05-2017.
 */
public class main
{
    public static void main(String[] args) {
        port(4321);
        new RegistrationController();

    }
}
