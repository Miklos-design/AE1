package AE1;

public class Runner {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory music = new Directory("music");
        Directory pictures = new Directory("pictures");
        Directory personal = new Directory("personal");
        Directory misc = new Directory("misc");

        // Create files
        File settings = new File("Settings", 10);
        File ringtone = new File("ringtone", 120);
        File familyHoliday = new File("family-holiday", 201);
        File portrait = new File("portrait", 134);
        File wallpaper = new File("wallpaper", 421);

        // Construct the directory structure
        root.add(settings);
        root.add(music);
        root.add(pictures);

        music.add(ringtone);
        pictures.add(personal);
        pictures.add(misc);
        personal.add(familyHoliday);
        personal.add(portrait);
        misc.add(wallpaper);
//        personal.add(misc);

        // Display the directory structure
        System.out.println(root.display("\t"));
    }
}
