package dao;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Ikastetxea;
public class DaoIkastetxeak {
   
	/**
	 * function that returns all schools
	 * @return ArrayList<Ikastetxea>
	 */
   public static ArrayList<Ikastetxea> getIkastetxeak() {
       ArrayList<Ikastetxea> ikastetxeak = new ArrayList<>();
       String path = "ikastetxeak.json";
       try {
           FileReader reader = new FileReader(path);
           JsonParser jsonParser = new JsonParser();
           JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);
           
           // Accede al array dentro del objeto
           JsonArray jsonarray = jsonObject.getAsJsonArray("IKASTETXEAK");
           for (JsonElement element : jsonarray) {
               JsonObject obj = element.getAsJsonObject();
               Ikastetxea ikastetxea = new Ikastetxea();
               // Utiliza funciones seguras para extraer valores, con valores por defecto
               ikastetxea.setCcen(safeGetAsInt(obj.get("CCEN"), 0)); // Por defecto, 0
               ikastetxea.setNom(safeGetAsString(obj.get("NOM"), ""));
               ikastetxea.setNome(safeGetAsString(obj.get("NOME"), ""));
               ikastetxea.setDgenrc(safeGetAsString(obj.get("DGENRC"), ""));
               ikastetxea.setDgenre(safeGetAsString(obj.get("DGENRE"), ""));
               ikastetxea.setGenr(safeGetAsString(obj.get("GENR"), ""));
               ikastetxea.setMuni(safeGetAsInt(obj.get("MUNI"), 0));
               ikastetxea.setDmunic(safeGetAsString(obj.get("DMUNIC"), ""));
               ikastetxea.setDmunie(safeGetAsString(obj.get("DMUNIE"), ""));
               ikastetxea.setDterrc(safeGetAsString(obj.get("DTERRC"), ""));
               ikastetxea.setDterre(safeGetAsString(obj.get("DTERRE"), ""));
               ikastetxea.setDepe(safeGetAsInt(obj.get("DEPE"), 0));
               ikastetxea.setDtituc(safeGetAsString(obj.get("DTITUC"), ""));
               ikastetxea.setDtitue(safeGetAsString(obj.get("DTITUE"), ""));
               ikastetxea.setDomi(safeGetAsString(obj.get("DOMI"), ""));
               ikastetxea.setCpos(safeGetAsInt(obj.get("CPOS"), 0));
               ikastetxea.setTel1(safeGetAsLong(obj.get("TEL1"), 0L)); // Por defecto, 0L
               ikastetxea.setTfax(safeGetAsLong(obj.get("TFAX"), 0L));
               ikastetxea.setEmail(safeGetAsString(obj.get("EMAIL"), ""));
               ikastetxea.setPagina(safeGetAsString(obj.get("PAGINA"), ""));
               ikastetxea.setCoorX(safeGetAsString(obj.get("COOR_X"), ""));
               ikastetxea.setCoorY(safeGetAsString(obj.get("COOR_Y"), ""));
               ikastetxea.setLatitud(safeGetAsDouble(obj.get("LATITUD"), 0.0)); // Por defecto, 0.0
               ikastetxea.setLongitud(safeGetAsDouble(obj.get("LONGITUD"), 0.0));
               ikastetxeak.add(ikastetxea);
           }
       } catch (IOException e) {
           System.err.println("Error al leer el archivo: " + e.getMessage());
       }
       return ikastetxeak;
   }
   private static String safeGetAsString(JsonElement element, String defaultValue) {
       return (element != null && !element.isJsonNull()) ? element.getAsString() : defaultValue;
   }
   private static int safeGetAsInt(JsonElement element, int defaultValue) {
       try {
           return (element != null && !element.isJsonNull()) ? element.getAsInt() : defaultValue;
       } catch (Exception e) {
           return defaultValue;
       }
   }
   private static long safeGetAsLong(JsonElement element, long defaultValue) {
       try {
           return (element != null && !element.isJsonNull()) ? element.getAsLong() : defaultValue;
       } catch (Exception e) {
           return defaultValue;
       }
   }
   private static double safeGetAsDouble(JsonElement element, double defaultValue) {
       try {
           return (element != null && !element.isJsonNull()) ? element.getAsDouble() : defaultValue;
       } catch (Exception e) {
           return defaultValue;
       }
   }
   
   /**
    * function that returns a school by its id
    * @param id
    * @return Ikastetxea
    */
   public static Ikastetxea getIkastetxeaById(int id) {
	   Ikastetxea ikastetxea = new Ikastetxea();
	   
	   ArrayList<Ikastetxea> ikastetxeaList = getIkastetxeak();
	   for (Ikastetxea ik : ikastetxeaList) {
           if (ik.getCcen() == id) {
               ikastetxea = ik;
               break;
           }
       }
	   
	   return ikastetxea;
   }
}

