# 588. Design In-Memory File System

Design a data structure that simulates an in-memory file system.

Implement the FileSystem class:

FileSystem() Initializes the object of the system.
List<String> ls(String path)
If path is a file path, returns a list that only contains this file's name.
If path is a directory path, returns the list of file and directory names in this directory.
The answer should in lexicographic order.
void mkdir(String path) Makes a new directory according to the given path. The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
void addContentToFile(String filePath, String content)
If filePath does not exist, creates that file containing given content.
If filePath already exists, appends the given content to original content.
String readContentFromFile(String filePath) Returns the content in the file at filePath.

Example 1:

Input
["FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"]
[[], ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]
Output
[null, [], null, null, ["a"], "hello"]

Explanation
FileSystem fileSystem = new FileSystem();
fileSystem.ls("/"); // return []
fileSystem.mkdir("/a/b/c");
fileSystem.addContentToFile("/a/b/c/d", "hello");
fileSystem.ls("/"); // return ["a"]
fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"

Constraints:

1 <= path.length, filePath.length <= 100
path and filePath are absolute paths which begin with '/' and do not end with '/' except that the path is just "/".
You can assume that all directory names and file names only contain lowercase letters, and the same names will not exist in the same directory.
You can assume that all operations will be passed valid parameters, and users will not attempt to retrieve file content or list a directory or file that does not exist.
1 <= content.length <= 50
At most 300 calls will be made to ls, mkdir, addContentToFile, and readContentFromFile.

## solution

需要注意的几个条件：

1. 需要区分是不是 file，ls file 只 return filename，ls dir return list of children files/dirs
2. ls should return in lexicographical order
3. mkdir 只 create dir
4. addfilecontent 只 create file + add content

## code

```java
//It is actually a TrieNode
class FileNode{
    boolean isFile = false;
    HashMap<String, FileNode> children;
    String content = "";

    public FileNode(){
        children = new HashMap<>();
    }
}

class FileSystem {

    public FileNode root = new FileNode();

    public FileSystem() {
        root = new FileNode();
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        String[] names = path.split("/");
        FileNode node = root;

        for(String name : names){
            if(name.length()==0) continue;
            if(!node.children.containsKey(name)){
                return res;
            }
            node = node.children.get(name);
        }

        if(node.isFile){
            res.add(names[names.length-1]);
        }
        else{
            for(String key : node.children.keySet()){
                res.add(key);
            }
        }

        Collections.sort(res, (s1, s2)->{
            return s1.compareTo(s2);
        });

        return res;
    }

    public void mkdir(String path) {
        String[] names = path.split("/");
        FileNode node = root;

        for(String name : names){
            //the first name is empty string
            if (name.length() == 0) continue;
            if(!node.children.containsKey(name)){
                FileNode dir = new FileNode();
                node.children.put(name, dir);
            }

            node = node.children.get(name);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileNode node = root;
        String[] names = filePath.split("/");

        for(String name : names){
            if(name.length()==0) continue;

            if(!node.children.containsKey(name)){
                FileNode file = new FileNode();
                node.children.put(name, file);
            }

            node = node.children.get(name);
        }
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        FileNode node = root;
        String[] names = filePath.split("/");

        for(String name : names){
            if(name.length()==0) continue;

            if(!node.children.containsKey(name)){
                FileNode file = new FileNode();
                node.children.put(name, file);
            }

            node = node.children.get(name);
        }

        return node.content;
    }
}
```
