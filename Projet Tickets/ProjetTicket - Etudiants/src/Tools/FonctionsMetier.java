/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Etat;
import Entity.Ticket;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbuffeteau
 */
public class FonctionsMetier 
{
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cnx;
   
   public FonctionsMetier()
   {
       cnx = ConnexionBDD.getCnx();
       
   }
   
   public User VerifierLogin (String login, String mdp)
   {
       User unUser= null;

       try {
           ps = cnx.prepareStatement("select idUser, nomUser, prenomUser, statutUser from users where loginUser ='"+login+"' and pwdUser ='"+mdp+"'");
           rs = ps.executeQuery();
           if(rs.next())
           {
               unUser= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
       }
       return unUser;
   }
}
