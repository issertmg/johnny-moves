import java.io.Serializable;

/** The class Account represents an
 *  account object containing
 *  a username and password.
 * 
 *  @author Isser Troy M. Gagan
 *  @version 1.0
 */
public class Account implements Serializable
{
    private String username;
    private String password;

    /** This constructor initializes the
     *  account's username and password.
     * 
     *    @param username the username of the account
     *    @param password the password of the account
     */
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    /** This method returns the account's username
     * 
     *     @return username of the account           
     */
    public String getUsername()
    {
        return username;
    }
    /** This method returns the account's password
     * 
     *     @return password of the account           
     */
    public String getPassword()
    {
        return password;
    }
    /** This method sets the account's password
     * 
     *     @param password the new password of the
     *                     account           
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}