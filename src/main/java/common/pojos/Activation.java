package common.pojos;

/*
{
  "mode": "INACTIVE",
  "operation": "IDLE"
}
 */
public class Activation extends DAO{

    private String mode;
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
