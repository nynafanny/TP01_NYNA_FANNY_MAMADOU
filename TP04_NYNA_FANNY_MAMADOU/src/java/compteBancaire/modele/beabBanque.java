/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compteBancaire.modele;

import javax.ejb.Stateless;
import compteBancaire.modele.CompteBancaire;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author NYNA FANNY
 */
@Stateless
public class beabBanque {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     private EntityManager em;
     public CompteBancaire creerCompteBancaire(String lastName, String firstName, String accountNumber, double balance) {
        CompteBancaire c = new CompteBancaire(lastName,firstName,accountNumber,balance);
        em.persist(c);
        return c;
}
}