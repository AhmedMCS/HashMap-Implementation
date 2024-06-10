package HashMap;
public class Driver {
    public static void main(String[] args) {
        HashMap <String, String> map = new HashMap <String, String> ();

        map.put("Cairo", "Egypt");
        map.put("Paris", "France");
        map.put("London", "United Kingdom");
        map.put("Rome", "Italy");
        map.put("Seoul", "Korea");
        map.remove("London");
        System.out.println(map);
        
    }
}