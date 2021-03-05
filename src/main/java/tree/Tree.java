package tree;

import java.util.List;

/**
 * @author toryxu
 * @version 1.0
 * @date 2020/10/19 8:26 下午
 */
public class Tree {

    public String name;

    public String length;

    public boolean tag;

    public boolean isTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    List<Tree> children;

    public Tree(String name, String length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
