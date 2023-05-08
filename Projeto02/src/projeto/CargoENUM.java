package projeto;

public enum CargoENUM {
    DESENVOLVEDOR("DESENVOLVEDOR"),
    TESTADOR("TESTADOR"),
    GERENTE("GERENTE"),
    DBA("DBA"),
	DUMMY("DUMMY");

    private final String cargo;

    private CargoENUM(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }
}