
package test;
import entities.Personne;
import services.PersonneService;
import utils.MyDatabase;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        PersonneService ps=new PersonneService();
        /*try {
            ps.ajouter(new Personne(22,"bouslimi","bouslimi"));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            ps.modifier(new Personne(7,21,"amal","bous"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }*/
        try {
            System.out.println(            ps.recuperer());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
