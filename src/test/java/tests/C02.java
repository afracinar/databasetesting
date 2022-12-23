package tests;

import org.junit.Assert;
import org.junit.Test;
import utililities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {

    //Yazili not ortalamasının 90dan kucuk oldugunu test edın

    @Test
    public void test02() throws SQLException {

        String hostname="localhost";
        String dbisim="Databasetesting";
        String username="postgres";
        String password="afra1234";

        //1.adım: connection oluştur
        DBUtils.connectionOlustur(hostname,dbisim,username,password);

        //2.adım: statement oluştur
        Statement st = DBUtils.statementOlustur();

        //3.adım: query oluşturma
        String query="select avg(yazili_notu) from ogrenciler;";

        //4.adım: query çalıştırma
        ResultSet rs = st.executeQuery(query); //resultsetin içinde query'den gelen data vardır
        rs.next();
        //tek bir değer döndüreceği için (ortalama) while loop içine koymaya gerek yok.ama next methodu kullanmak şart
          double ort = rs.getDouble(1);
        System.out.println(ort);

        Assert.assertTrue(ort<90);

      //  DBUtils.connectionStatementKapat();


    }
}
