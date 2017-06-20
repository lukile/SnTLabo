package employes;

public enum TypeCollaborateur {
    MEDECIN(1, "medecin"),
    SCIENTIFIQUE(2, "scientifique"),
    COMMERCIAUX(3, "commercial");

    private int choice;
    private String tableName;

    TypeCollaborateur(int choice, String tableName) {
        this.choice = choice;
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public static TypeCollaborateur valueOf(int i) {
        for (TypeCollaborateur typeCollaborateur : values()) {
            if (typeCollaborateur.choice == i)
                return typeCollaborateur;
        }
        return null;
    }
}
