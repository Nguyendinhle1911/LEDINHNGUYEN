package LAP6;

/**
 * viét lớp client tại đây
 * @author (tên của bạn)
 * @version (số phiên bản hoặc ngày)
 */
public class Client {
    public Client() {
        //to do :
    }
    public void doUnchecked(String value){
        // cần phải check exception , nêuas không --> bug
        int result=canThrowUncheckedException(value);
        System.out.println("result="+result);
    }
    private int canThrowUncheckedException(String value) {
        Integer integer = null;
        return Integer.parseInt(value);

    }
    public void doChecked(){
        try {
            // bước phải check exceptions ở đây ! không cách nào khác
            canThrowCheckedException();
            System.out.println("ok");
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void canThrowCheckedException() throws Exception {
        throw new Exception("Failure");
    }
}
