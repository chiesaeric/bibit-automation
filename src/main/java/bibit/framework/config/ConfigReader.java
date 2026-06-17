package bibit.framework.config;


import java.io.InputStream;
import java.util.Properties;



public class ConfigReader {


    private static Properties properties =
            new Properties();



    static {


        loadProperties();

    }





    private static void loadProperties(){


        String env =
            System.getProperty(
                "env",
                "qa"
            );


        String file =
            "config/"
            + env
            + ".properties";



        try {


            InputStream input =
                ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream(
                        file
                    );



            if(input == null){

                throw new RuntimeException(
                    "Config file not found: "
                    + file
                );

            }



            properties.load(input);



        } catch(Exception e){


            throw new RuntimeException(
                "Failed load config",
                e
            );

        }


    }





    public static String get(
            String key
    ){

        return properties
                .getProperty(key);

    }

}