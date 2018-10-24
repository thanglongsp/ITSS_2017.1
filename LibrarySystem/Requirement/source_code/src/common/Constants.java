/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package common;

/**
 *
 * @author longdragon
 */
public class Constants {
//    Login state constants
    public static final int LOGIN_SUCCESS = 1;
    public static final int WRONG_EMAIL = 2;
    public static final int WRONG_PASS  = 3;
    public static final int ACC_NOT_ACTIVATED = 4;
    
//    card status constants
    public static int NOT_ACTIVATED = 0;
    public static int ACTIVATED = 1;  
//    update card constants
    public static final int ERR_INVALID_DATE = 2;
    public static final int SUCESS = 1;
    public static final int FAILED = 0;

    public static int BOOK_AVAILABLE = 1;
    public static int BOOK_BORROWED = 2;
    public static int BOOK_LENT = 3;
    public static int BOOK_REFERENCED = 4;

    public static int UPDATE_SUCCESS = 1;
    public static int UPDATE_FAIL = 0;

//   role user
    public static final int USR = 1;
    public static final int ADM = 2;
    public static final int LIB = 3;
    
//    status borrowed-history_copy
    public static final int UNRETURNED = 0;
    public static final int RETURNED = 1;
    
//    status copy table
    public static final int BORROWED = 0;
    public static final int UNBORROWED = 1;
    public static final int REGISTERED = 2;
    
//    registration table status
    public static final int CHUALAY = 0;
    public static final int DALAY = 1;
    public static final int CANCELED = 2;
    public static final int QUAHAN = 3;
    
//    register to borrow book constant
    public static final int CARDEXPIRED = 1;
    public static final int OVERDUEBOOK = 2;
    public static final int BOOKNOTAVAILABLE = 3;
    public static final int OVERLIMIT = 4;
    public static final int REGISTERSUCCESS = 5;
    public static final int BOOKREGISTERED = 6;
}
