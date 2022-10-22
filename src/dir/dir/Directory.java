package dir;
import java.io.Serializable;

public class Directory implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String src;

    public Directory(){ }
    public Directory(String name, String src){

        this.name = name;
        this.src = src;
    }
    public Directory(int id, String name, String src){

        this.id = id;
        this.name = name;
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
