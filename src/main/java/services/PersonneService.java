package services;

import entities.Personne;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneService implements IService<Personne> {
    private Connection connection;
    public PersonneService()
    {
        connection= MyDatabase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Personne personne) throws SQLException {
        //specification de la req
        String sql = "INSERT INTO personne (nom, prenom, age) "
                + "VALUES ('" + personne.getNom() + "', '" + personne.getPrenom() + "', " + personne.getAge() + ")";

        //plus rapide que preparedStatement ki yebda andich des parametres
        //4 etapes(1-analyse,2-compilation,3-optimisation,4-execution)
        Statement st= connection.createStatement();
        st.executeUpdate(sql);

    }

    @Override
    public void modifier(Personne personne) throws SQLException {
        String sql="update personne set nom=?, prenom=?, age=? where id=?";

        //plus sécurisé contre les attaques sql injection
        //methode précompilé
        //2 etapes(1-phase de preparation(1-analyse,1-compilation,1-optimisation),2-execution)

        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,personne.getNom());
        ps.setString(2,personne.getPrenom());
        ps.setInt(3,personne.getAge());
        ps.setInt(4,personne.getId());
        ps.executeUpdate();


    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public List<Personne> recuperer() throws SQLException {
        String sql="select * from personne";
        Statement st= connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Personne> personnes =new ArrayList<>();
        while (rs.next()){
            Personne p =new Personne();
            // p.setId(rs.getInt(1));
            p.setId(rs.getInt("id"));
            p.setAge(rs.getInt("age"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));

            personnes.add(p);
        }
        return personnes;

    }
}
