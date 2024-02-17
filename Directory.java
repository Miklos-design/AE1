package AE1;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component {
    private String name;
    private List<Component> fileList;
    private static String initialPrefix = "";
    private String folderPrefix="";

    public void setFolderPrefix(String folderPrefix) {
        this.folderPrefix = folderPrefix;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public int getSize() {
        int totalSize = 0;
        for (Component f : fileList) {
            totalSize += f.getSize();
        }
        return totalSize;
    }

    @Override
    public int getCount() {
        int count = 0;
        for (Component f : fileList) {
            count += f.getCount();
        }
        return count;
    }
    public Directory(String name) {
        this.name = name;
        this.fileList = new ArrayList<>();
    }
    public void add(Component c) {
        fileList.add(c);
    }

    public void remove(Component c) {
        fileList.remove(c);
    }

    @Override
    public String display(String initialPrefix) {
        // Set the static initial prefix
        this.initialPrefix = initialPrefix;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(folderPrefix).append(this);

        // Call the method for recursion and append its result to the string builder
        displayContents(stringBuilder, folderPrefix);

        return stringBuilder.toString();
    }

    private void displayContents(StringBuilder stringBuilder, String folderPrefix) {
        // Append initial prefix for subdirectories
        folderPrefix += initialPrefix;
        for (Component f : fileList) {
            // Append the file or directory with the amended prefix
            stringBuilder.append("\n").append(folderPrefix).append(f);
            if (f instanceof Directory) {
                ((Directory) f).setFolderPrefix(folderPrefix);
                ((Directory) f).displayContents(stringBuilder, folderPrefix );
            }
        }
    }

    @Override
    public Component search(String name) {
        for (Component component : fileList) {
            if (component!=null &&
                    component instanceof File &&
                    component.getName().equals(name)) {
            return this;
        }   else if (component instanceof Directory) {
            Component found = ((Directory) component).search(name);
            if (found != null) {
                return found;
            }
        }
    }
    return null;
    }

    @Override
    public String toString() {
        return  name + ": (count=" + getCount() + ", size=" + getSize() + ")";
    }


}


