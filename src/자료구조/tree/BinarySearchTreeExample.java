package 자료구조.tree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeExample {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(4);
        bst.insertNode(3);
        bst.insertNode(0);
        bst.insertNode(1);
        bst.insertNode(2);
        bst.insertNode(5);

        bst.preorderTree(bst.rootNode, 0);
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BinarySearchTree {
    Node rootNode;

    public void insertNode(int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else {
            Node head = rootNode;
            Node tempNode;
            while (true) {
                tempNode = head;
                //현재 루트보다 작은경우, 왼쪽으로 탐색
                if (head.value > value) {
                    head = head.left;
                    if (head == null) {
                        tempNode.left = new Node(value);
                        break;
                    }
                } else {
                    //현재 루트보다 큰 경우, 오른쪽으로 탐색
                    head = head.right;
                    if (head == null) {
                        tempNode.right = new Node(value);
                        break;
                    }
                }
            }
        }
    }

    public boolean removeNode(int element){
        //삭제할 노드가 존재하는지 확인
        boolean searched = false;
        Node parent = rootNode;
        Node currentNode = rootNode;

        while(currentNode != null){
            if(currentNode.value == element){
                searched = true;
                break;
            }else if(element < currentNode.value){
                parent = currentNode;
                currentNode = currentNode.left;
            }else{
                parent = currentNode;
                currentNode = currentNode.right;
            }
        }

        //삭제할 노드가 없을경우 리턴 false
        if(!searched){
            return false;
        }
        //1. 삭제 대상이 leaf 노드일때
        if(currentNode.left == null && currentNode.right == null){
            if(parent.value > currentNode.value){ //삭제할 노드가 부모 노드의 왼쪽 자식일 경우
                parent.left = null;
            }else{ //삭제할 노드가 부모 노드의 오른쪽 자식일 경우
                parent.right = null;
            }
        }

        //2. 삭제 대상의 자식 노드가 1개일때
        //2.1 왼쪽 자식일때
        if(currentNode.left != null && currentNode.right == null){
            if(parent.value < currentNode.value){ //삭제 노드가 부모노드의 오른쪽 자식일때
                parent.right = currentNode.left;
            }else{
                parent.left = currentNode.left;
            }
        }
        //2.2 오른쪽 자식일때
        else if (currentNode.left == null && currentNode.right != null) {
            if(parent.value < currentNode.value){ //삭제 노드가 부모 노드의 오른쪽 자식일때
                parent.right = currentNode.right;
            }else{
                parent.left = currentNode.right;
            }
        }
        //3. 삭제 대상의 자식 노드가 2개일때
        if(currentNode.left != null && currentNode.right != null){
            if(currentNode.value < parent.value){
                //3.1 삭제할 대상의 오른쪽 자식들 중에 가장 작은 값을 현재 삭제 노드로 옮긴다. (오른쪽 트리의 마지막 레벨의 왼쪽 노드)
                //changeNode, changeParentNode 기초세팅
                Node changeParentNode = currentNode;
                Node changeNode = currentNode.right;

                //changeNode, changeParentNode 찾기 - 가장 왼쪽 노드로 이동
                while(changeNode.left != null){
                    changeParentNode = changeNode.left;
                    changeNode = changeNode.left;
                }
                //3.1.1 해당 노드의 오른쪽 브랜치에 자식 노드가 있으면
                if(changeNode.right != null){
                    //3.1.2 해당 노드의 부모 노드 왼쪽 브랜치에 해당 노드의 오른쪽 자식 노드 연결
                    changeParentNode.left = changeNode.right;
                }else{ //해당 노드의 오른쪽 브랜치에 자식 노드가 없으면
                    changeParentNode.left = null;
                }
                //3.1.3 삭제할 대상의 부모 노드의 왼쪽 브랜치를 해당 노드에 연결
                parent.left = changeNode;
                //3.1.4 삭제할 대상의 왼쪽 자식을 해당 노드 왼쪽 브랜치로 연결, 삭제할 대상의 오른쪽 자식을 해당 노드 오른쪽 브랜치로 연결
                changeNode.left = currentNode.left;
                changeNode.right = currentNode.right;
            }else{
                //3.1 삭제할 대상의 오른쪽 자식들 중에 가장 작은 값을 현재 삭제 노드로 옮긴다. (오른쪽 트리의 마지막 레벨의 왼쪽 노드)
                //changeNode, changeParentNode 기초세팅
                Node changeParentNode = currentNode.left;
                Node changeNode = currentNode.right;

                //changeNode, changeParentNode 찾기 - 가장 왼쪽 노드로 이동
                while(changeNode.left != null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //3.1.1 해당 노드의 오른쪽 브랜치에 자식 노드가 있으면
                if(changeNode.right != null){
                    //3.1.2 해당 노드의 부모 노드 왼쪽 브랜치에 해당 노드의 오른쪽 자식 노드 연결
                    changeParentNode.left = changeNode.right;
                }else{ //해당 노드의 오른쪽 브랜치에 자식 노드가 없으면
                    changeParentNode.left = null;
                }
                //3.1.3 삭제할 대상의 부모 노드의 오른쪽 브랜치를 해당 노드에 연결
                parent.right = changeNode;
                changeNode.left = currentNode.left;
                changeNode.right = currentNode.right;
            }
        }
        return true;
    }

    /**
     * 전위 순회
     */
    public void preorderTree(Node root, int depth) {
        if (root != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("ㄴ");
            }
            System.out.println(root.value);
            preorderTree(root.left, depth + 1);
            preorderTree(root.right, depth + 1);
        }
    }

}



































