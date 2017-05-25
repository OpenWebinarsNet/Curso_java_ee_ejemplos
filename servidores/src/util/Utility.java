package util;

public class Utility {

   private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

   /**
    * Metodo para generar una cadena de caracteres aleatorios con la longitud pasada como parametro.
    * @param count
    * @return 
    */
   public static String randomAlphaNumeric(int count) {

      StringBuilder builder = new StringBuilder();

      while (count-- != 0) {
         int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
         builder.append(ALPHA_NUMERIC_STRING.charAt(character));
      }
      return builder.toString();

   }

}
