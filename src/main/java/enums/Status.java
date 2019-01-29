package enums;

public enum Status {

    OK("ok"),
    ATRASADO ("atrasado"),
    INADIMPLENTE ("inadimplemte"),
    BLOQUEADO ("bloqueado");

    private final String status = null;

    Status(String situacao){
        situacao = status;
    }

    public String getStatus() {
        return status;
    }
}
