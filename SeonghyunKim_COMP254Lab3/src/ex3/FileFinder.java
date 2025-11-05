import java.io.File;

/*
Implement a recursive method with signature find(path, filename)
that reports all entries of the file system rooted at the given path
having the given file name.
*/

public class FileFinder {

    /**
     * Recursively searches for files matching filename in the given path.
     * 
     * Base case: if path is a file → check if it matches filename.
     * Recursive step: if path is a directory → explore all children recursively.
     * 
     * Running time: O(n), where n = total number of files and folders.
     */
    public static void find(String path, String filename) {
        File dir = new File(path);

        if (!dir.exists()) {
            System.out.println("Path does not exist: " + path);
            return;
        }

        if (dir.isFile()) {
            if (dir.getName().equalsIgnoreCase(filename))
                System.out.println("Found: " + dir.getAbsolutePath());
            return;
        }

        // If it's a directory, recurse through all entries
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File f : entries)
                find(f.getAbsolutePath(), filename);
        }
    }

    public static void main(String[] args) {
        // Example usage — test with an existing folder on your system
        String searchPath = "C:\\Users\\xoxok\\OneDrive\\Centennial"; // change to your path
        String searchFile = "README.txt"; // example filename

        System.out.println("Searching for \"" + searchFile + "\" under " + searchPath + " ...\n");
        find(searchPath, searchFile);

        System.out.println("\nRunning time: O(n) where n = number of files/folders checked.");
    }
}
