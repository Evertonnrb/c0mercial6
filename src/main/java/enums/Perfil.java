package enums;

public enum Perfil {

    USUARIO ("usuario"),
    VENDEDOR ("vendedor"),
    ADM ("adm");

    private final String perfil = null;

    Perfil(String tipoPerfil){
        tipoPerfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
