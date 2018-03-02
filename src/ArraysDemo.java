import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by windvalley on 2018/2/24.
 */
class Person4Comparator{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person4Comparator(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名:" + name + " 年龄:" + age;
    }
}

//用于原始类没有实现Comparable接口,后期也无法修改时使用
class PersonComparator implements Comparator<Person4Comparator>{
    @Override
    public int compare(Person4Comparator o1, Person4Comparator o2) {
        return o1.getAge() - o2.getAge();
    }
}


class Person4ArrayDemo implements Comparable<Person4ArrayDemo> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person4ArrayDemo(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名:" + name + " 年龄:" + age;
    }

    @Override
    public int compareTo(Person4ArrayDemo o) {
        if (getAge() > o.getAge()){
            return 1;
        } else {
            if (getAge() < o.getAge()){
                return -1;
            } else {
                return 0;
            }
        }
    }
}

//二叉树
class BinaryTree{
    private class Node {
        private Comparable data;
        private Node left; //比根节点小的数据
        private Node right;//比根节点大或者等于的数据
        public Node(Comparable data){
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.data.compareTo(newNode.data) > 0){
                if (this.left == null){
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null){
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null){
                this.left.toArrayNode();
            }

            //btree是有序的,对应index = index + 1;
            BinaryTree.this.retData[BinaryTree.this.index] = this.data;
            index = index + 1;

            if (this.right != null){
                this.right.toArrayNode();
            }
        }
    }

    private Node root;   //必须保留根节点
    private int count = 0;
    private int index = 0;
    private Object[] retData;
    public void add(Object object){
        Comparable data = (Comparable) object;
        Node newNode = new Node(data);
        if (this.root == null){
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        count = count + 1;
    }

    public Object[] toArray(){
        if (count > 0){
            index = 0;
            retData = new Object[count];
            this.root.toArrayNode();
            return retData;
        }
        else {
            return null;
        }
    }
}

public class ArraysDemo {
    public static void main(String[] args){
        binSearch();
        equseArray();
        sortObject();
        binTree();
        comparatorArray();
    }

    private static void comparatorArray() {
        Person4Comparator person[] = new Person4Comparator[]{
                new Person4Comparator("张三", 18),
                new Person4Comparator("李四", 28),
                new Person4Comparator("王五", 38),
                new Person4Comparator("赵六", 8),
        };

        Arrays.sort(person, new PersonComparator());
        System.out.println(Arrays.toString(person));
    }

    private static void binTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(new Person4ArrayDemo("张三", 18));
        binaryTree.add(new Person4ArrayDemo("刘所", 24));
        binaryTree.add(new Person4ArrayDemo("李四", 28));
        binaryTree.add(new Person4ArrayDemo("王五", 8));
        binaryTree.add(new Person4ArrayDemo("赵六", 38));
        binaryTree.add(new Person4ArrayDemo("赵六1", 20));

        System.out.println(Arrays.toString(binaryTree.toArray()));
    }

    private static void sortObject() {
        Person4ArrayDemo person[] = new Person4ArrayDemo[]{
                new Person4ArrayDemo("张三", 18),
                new Person4ArrayDemo("李四", 28),
                new Person4ArrayDemo("王五", 38),
                new Person4ArrayDemo("赵六", 8),
        };

        Arrays.sort(person);
        System.out.println(Arrays.toString(person));
    }

    private static void equseArray() {
        int[] arraysA = new int[]{10,30,495,2,3923,323};
        int[] arraysB = new int[]{10,30,495,2,3923,323};
        java.util.Arrays.sort(arraysA);
        java.util.Arrays.sort(arraysB);
        System.out.println(Arrays.equals(arraysA,arraysB));
    }

    //二分法查找必须是一个有序表
    private static void binSearch() {
        int[] arrays = new int[]{10,30,495,2,3923,323};
        java.util.Arrays.sort(arrays);
        System.out.println(java.util.Arrays.binarySearch(arrays, 323));
    }
}