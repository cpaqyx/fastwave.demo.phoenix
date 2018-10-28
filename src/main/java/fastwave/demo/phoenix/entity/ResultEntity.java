package fastwave.demo.phoenix.entity;

/**
 * @autor cp
 * @Date 2018/10/28
 */
public class ResultEntity {

    boolean status;

    String message;

    public ResultEntity(boolean status, String message) {
        this.status = status;
        this.message = message;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
