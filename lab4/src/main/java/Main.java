import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
//import java.security.IdentityScope;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rpgPu");
        EntityManager em = emf.createEntityManager();

    /*
        em = emf.createEntityManager();
        Mage wolf = em.find(Mage.class, "adam");
        System.out.println(wolf);
        em.close();
    */
        int decision=-1;
        boolean working=true;
        int changedRows;
        String queryString;
        Query query;
        Mage mage;
        Tower tower;
        String name;
        Scanner scanner= new Scanner(System.in);


        while(working){
            decision=scanner.nextInt();
            scanner.nextLine(); // wczytanie \n
            switch (decision){
                case 0: working=false; break;
                case 1: //dodaj maga
                    System.out.println("add mage");
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    mage=new Mage();
                    System.out.print("name: ");
                    mage.setName(scanner.nextLine());
                    System.out.print(mage.getName()+"'s level: ");
                    mage.setLevel(scanner.nextInt());
                    scanner.nextLine(); // wczytanie \n
                    //System.out.print("Tower's name: ");
                    //mage.setTower(scanner.nextLine());

                    em.persist(mage);
                    em.getTransaction().commit();
                    em.close();
                    break;

                case 2://add tower
                    System.out.println("add tower");
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    tower=new Tower();
                    System.out.print("name: ");
                    tower.setName(scanner.nextLine());
                    System.out.print(tower.getName()+"'s level: ");
                    tower.setHeight(scanner.nextInt());
                    em.persist(tower);
                    em.getTransaction().commit();
                    em.close();
                    break;
                case 3: //delete mage
                    System.out.println("delete mage");
                    em = emf.createEntityManager();
                    em.getTransaction().begin();

                    System.out.print("name: ");
                    name=scanner.nextLine();
                    queryString = "DELETE FROM Mage p WHERE p.name= :name";
                    query = em.createQuery(queryString).setParameter("name",name);
                    changedRows = query.executeUpdate();

                    em.getTransaction().commit();
                    em.close();
                    break;


                case 4: //show mages
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    queryString = "SELECT p FROM Mage p";
                    query = em.createQuery(queryString, Mage.class);
                    List<Mage> mages = query.getResultList();
                    System.out.println(mages);
                    em.close();
                    break;
                case 5: //show towers
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    queryString = "SELECT p FROM Tower p";
                    query = em.createQuery(queryString, Tower.class);
                    List<Tower> towers = query.getResultList();
                    System.out.println(towers);
                    em.close();
                    break;
                case 6: //sql query
                    break;
            }
        }

        System.out.println("App closed");

        emf.close();
    }
}
