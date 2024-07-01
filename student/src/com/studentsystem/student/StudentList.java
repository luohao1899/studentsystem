package com.studentsystem.student;

public class StudentList {
    private final Node head;
    private Node tail;
    private int length;


    public StudentList() {
        this.head = new Node();
        this.tail = this.head;
    }

    /** 添加数据 */
    public void add(String id, String name, int age, String address) {
        boolean ret = false;
        Node newNode = new Node(id, name, age, address);
        newNode.setPre(this.tail);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    /** 删除数据 */
    public void delete(String id) {
        Node node = this.head.getNext();
        while (node != null) {
            if (node.getStudent().getId().equals(id)) {
                node.getPre().setNext(node.getNext());
                if(node.getNext() != null){
                    node.getNext().setPre(node.getPre());
                    this.length--;
                }
            }
            node = node.getNext();
        }
    }

    /** 修改数据 */
    public void update(String id, String sign, String data) {
        Node node = this.findNode(id);
        switch (sign) {
            case "id" -> node.getStudent().setId(data);
            case "name" -> node.getStudent().setName(data);
            case "address" -> node.getStudent().setAddress(data);
        }
    }

    /** 修改数据(age) */
    public void update(String id, String sign, int data) {
        if (sign.equals("age")) {
            Node node = this.findNode(id);
            node.getStudent().setAge(data);
        }
    }
    
    /** 查询数据 */
    public String query() {
        StringBuilder ret = new StringBuilder("id\t\tname\tage\t\taddress\n");
        Node node = this.head.getNext();
        while (node != null) {
            ret.append(
                    node.getStudent().getId()
            ).append(
                    "\t\t"
            ).append(
                    node.getStudent().getName()
            ).append(
                    "\t\t"
            ).append(
                    node.getStudent().getAge()
            ).append(
                    "\t\t"
            ).append(
                    node.getStudent().getAddress()
            ).append(
                    "\n"
            );
            node = node.getNext();
        }
        return ret.toString();
    }

    /** id唯一性判断 */
    public boolean repeat(String id) {
        boolean ret = false;
        Node node = this.head.getNext();
        while (node != null && !ret) {
            ret = node.getStudent().getId().equals(id);
            node = node.getNext();
        }
        return ret;
    }

    /** 链表长度 */
    public int size() {
        return this.length;
    }

    /** 节点查找 */
    private Node findNode(String id) {
        Node retNode = null;
        Node node = this.head.getNext();
        while (node != null) {
            if (node.getStudent().getId().equals(id)) {
                retNode = node;
            }
            node = node.getNext();
        }
        return retNode;
    }
}
