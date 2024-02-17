package AE1;

public class File implements Component {
    private String name;
    private int size;
    private int count;


    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCount() {
        return 1;
    }


    @Override
    public Component search(String name) {
        return this.name.equals(name) ? this : null;
    }

    @Override
    public String display(String prefix) {
        return "\n"+ prefix + toString() ;
    }


    @Override
    public String toString( ) {
        return name  + "("+ size +")" ;
    }

}
