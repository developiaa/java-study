package basic.copy;

import java.util.ArrayList;
import java.util.List;

public class DevelopiaList implements Cloneable {
    List<Integer> list = new ArrayList<>();

    public DevelopiaList() {
    }

    public DevelopiaList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public DevelopiaList clone() throws CloneNotSupportedException {
        return (DevelopiaList) super.clone();
    }

    public DevelopiaList deepClone() throws CloneNotSupportedException {
        return new DevelopiaList();
    }
}
