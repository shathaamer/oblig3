package com.example.oblig3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
class BilletterComparator implements Comparator<Billett> {
    @Override
    public int compare(Billett b1, Billett b2) {
        int diff = b1.getEtternavn().compareTo(b2.getEtternavn());
        if (diff == 0) {
            diff = b1.getFornavn().compareTo(b2.getFornavn());
        }
        return diff;
    }
}
@Repository
public class BillettRepository {
    @Autowired
    private JdbcTemplate db;
   public void lagreBilletter(Billett b){
       String sql="INSERT INTO Billetter(film, antall, fornavn, etternavn, telefonnr, epost) VALUES(?,?,?,?,?,?)";
       db.update(sql);
   }
   public List<Billett> hentBilletter(){
       String sql="SELECT * FROM Billetter ";
       List<Billett> alleBilletter=db.query(sql, new BeanPropertyRowMapper());
       alleBilletter.sort( new BilletterComparator());
       return alleBilletter;
   }
   public void slettBilletter(){
       String sql="DELETE FROM Billetter";
       db.update(sql,db);
   }
}
