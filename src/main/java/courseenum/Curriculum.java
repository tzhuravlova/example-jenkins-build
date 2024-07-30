package courseenum;

public enum Curriculum {
    AQE("Automation Quality Engineer"),
    JD("Java Developer");

    String displayName;
    Curriculum(String displayName){
        this.displayName = displayName;
    }
}
