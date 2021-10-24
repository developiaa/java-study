import java.util.ArrayList;

class MaterialObject {
    public void doPrint(){
        System.out.println("object");
    };
}

class Material extends MaterialObject {
    public void doPrint() {
        System.out.println("material");
    }
}

class Plastic extends Material {

    @Override
    public void doPrint() {
        System.out.println("plastic");
    }
}


class Powder extends Material {

    @Override
    public void doPrint() {
        System.out.println("Powder");
    }
}

public class Hierarchy {
    public static void main(String[] args) {
        ArrayList<Material> list = new ArrayList<>();
        Powder powder = new Powder();
        Plastic plastic = new Plastic();


        list.add(powder);
        list.add(plastic);

        for (Object o : list) {
            System.out.println(o);
        }

        ArrayList<? super Material> list2 = new ArrayList<>();
//        list2.add(new MaterialObject());
        list2.add(new Material());
        list2.add(new Powder());
        list2.add(new Plastic());

        ArrayList<? extends Material> list3 = new ArrayList<>();
//        list3.add(new MaterialObject());
//        list3.add(new Material());
//        list3.add(new Powder());
//        list3.add(new Plastic());
    }
}
