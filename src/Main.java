public class Main {
    public static void main(String[] args) {
        Field field = new Field(200);
        field.clearField();
        field.showField();
        Player ivan = new Player("Ivan",0,'x',true);
        Player comp = new Player("Comp",1,'o',false);

        field.drowSymbol(ivan,2,1);
        field.drowSymbol(comp,1,1);
    }
}