package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author toryxu
 * @version 1.0
 * @date 2020/10/19 8:27 下午
 */
public class TreeTest {

    public static void main(String[] args) {
        List<Tree> biggerTree = new ArrayList<>();
        Tree bTree1 = new Tree("1", "100");
        Tree bTree2 = new Tree("2", "100");
        Tree bTree3 = new Tree("3", "100");
        Tree bTree4 = new Tree("4", "100");
        bTree2.setChildren(Collections.singletonList(bTree4));
        List<Tree> bChildren = new ArrayList<>();
        bChildren.add(bTree2);
        bChildren.add(bTree3);
        bTree1.setChildren(bChildren);
        biggerTree.add(bTree1);

        List<Tree> smallerTree = new ArrayList<>();
        Tree sTree1 = new Tree("1", "100");
        Tree sTree2 = new Tree("2", "100");
        Tree sTree4 = new Tree("4", "100");
        sTree2.setChildren(Collections.singletonList(bTree4));
        List<Tree> sChildren = new ArrayList<>();
        sChildren.add(sTree2);
        bTree1.setChildren(sChildren);
        biggerTree.add(bTree1);
//
//        for (Tree tree : biggerTree) {
//            while()
//        }

    }
}
