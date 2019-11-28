package DBLinkerTestingClasses;

import BasicEntities.RegisteredUser;
import DBLinkers.RegisteredUserLinker;
import java.util.Calendar;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Administrator
 */
public final class RUserDBAPITest {

    private RegisteredUserLinker userLinker;

    public RUserDBAPITest() {
        userLinker = new RegisteredUserLinker();
        testRead();
        testWrite();
        testUpdate();
    }//end cons

    public void testRead() {
        // Testing reading from registered user db link:
        RegisteredUser user1 = userLinker.readSingleUserFromDB(4);
        System.out.println("User1: " + user1.getUsername());
        
        String username = "John Zan";
        String password = "123456";
        boolean userCorrect = userLinker.verifySingleUser(username, password);
        if(userCorrect)
            System.out.println(userLinker.getRegisteredUser().getUserid());
        else
            System.out.println("Password false!");
        
        System.out.println("Test RegisteredUser read no problem!\n");
    }//end method test read

    public void testWrite() {
        //Testing register user to db link:
        RegisteredUser newUser = new RegisteredUser();
        newUser.setUsername("Sam K");
        String str = "123456";
        String strPass = DigestUtils.sha1Hex(str);
        newUser.setPassword(strPass);
        newUser.setEmail("samy@163.com");
        Calendar cal = Calendar.getInstance();
        newUser.setRegisteredTime(cal);
        userLinker = new RegisteredUserLinker();
        userLinker.setRegisteredUser(newUser);
        userLinker.registerUser();
        
       System.out.println("Test RegisteredUser write no problem!");
    }//end method test write

    public void testUpdate() {
        // Testing registered user to db link:
        RegisteredUser updatingUser = new RegisteredUser();
        updatingUser.setUserid(3);
        updatingUser.setUsername("John Zan");
        updatingUser.setPassword(DigestUtils.sha1Hex("123456"));
        updatingUser.setEmail("johnz@edinburgh.edu");
        //The second bool is for whether user is registering.
        userLinker = new RegisteredUserLinker();
        //Set the user object first in order to get information later:
        userLinker.setRegisteredUser(updatingUser);
        userLinker.updateDB();
       
        String str = "123456";
        String strPass = DigestUtils.sha1Hex(str);
        
        if(strPass.equals(updatingUser.getPassword()))        
            System.out.println("Password: " + updatingUser.getPassword());
        
        System.out.println("Test RegisteredUser update no problem!");
    }//end method test update
    
}//end class
