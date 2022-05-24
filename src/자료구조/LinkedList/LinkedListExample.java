package 자료구조.LinkedList;

import com.sun.source.tree.BreakTree;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        String str = "wed";
        linkedList.insertNode("sun");
        linkedList.insertNode("mon");
        linkedList.insertNode("tue");
        linkedList.insertNode("wed");
        linkedList.insertNode("thu");
        linkedList.insertNode("fri");
        linkedList.insertNode("sat");
        linkedList.printList();

        System.out.println(linkedList.searchNode(str).getData());


        linkedList.deleteNode("test");
        linkedList.printList();

        str = "sun";
        System.out.println();
        linkedList.deleteNode(linkedList.searchNode(str).getData());
        linkedList.printList();
    }

    static class ListNode{
        private String data;
        private ListNode link;

        public ListNode() {
            this.data = null;
            this.link = null;
        }

        public ListNode(String data) {
            this.data = data;
        }

        public ListNode(String data, ListNode link) {
            this.data = data;
            this.link = link;
        }
        public String getData(){
            return this.data;
        }
    }

    static class LinkedList{
        private ListNode head;

        public LinkedList() {
            this.head = null;
        }

        public void insertNode(ListNode preNode, String data){
            ListNode newNode = new ListNode(data);

            //preNode.link = preNode의 다음 노드 이므로, newNode.link = preNode.link는 새로운 노드의 link가 preNode의 다음 노드를 참조하게함
            newNode.link = preNode.link;
            //preNode의 link가 새로운 노드를 참조하게 함
            preNode.link = newNode;
        }


        public void insertNode(String data){
            ListNode newNode = new ListNode(data);
            if(head == null){
                //head 노드가 null인 경우 새로운 노드를 참조하게 함
                this.head = newNode;
            }else{
                //head 노드가 null이 아닌 경우 temp 노드가 head를 참조, tempNode는 마지막 노드를 찾아서 참조하기 위해 사용
                ListNode tempNode = head;

                //temp 노드의 link가 null이 아닐 때가지 다음 노드를 참조, tempNode.link는 다음 노드를 참조하고 있으므로, tempNode = tempNode.link는 tempNode에 다음 노드를 참조하도록 함
                //while 문이 모두 실행이 되면 tempNode는 가장 마지막 노드를 참조하게 됨
                while(tempNode.link != null){
                    tempNode = tempNode.link;
                }
                //tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 함
                tempNode.link = newNode;
            }
        }

        public void deleteNode(String data){
            //preNode는 head가 가리키는 노드를 할당
            ListNode preNode = head;
            //tempNode는 head가 가리키는 노드의 다음 노드. 즉 preNode의 다음 노드를 할당
            ListNode tempNode = head.link;

            //주어진 데이터가 preNode의 데이터와 일치하는 경우, 즉 첫번째 노드의 데이터와 일치하는 경우
            if(data.equals(preNode.getData())){
                //head는 preNode의 다음 노드를 참조하도록 함.
                head = preNode.link;
                //preNode의 link는 null을 할당하여 연결을 끊음
                preNode.link = null;
            }else{
                //tempNode가 null일때까지 반복하여 탐색
                while(tempNode != null){
                    //주어진 데이터와 temp 노드의 데이터가 일치하는경우
                    if(data.equals(tempNode.getData())){
                        //tempNode가 마지막 노드인 경우
                        if(tempNode.link == null){
                            preNode.link = null;
                        }else{
                            //tempNode가 마지막 노드가 아닌 경우
                            //preNode의 link는 tempNode의 다음 노드를 참조
                            //tempNode의 link는 null을 할당하여 다음 노드의 연결을 끊음
                            preNode.link = tempNode.link;
                            tempNode.link = null;
                        }
                        break;
                    }else{
                        //데이터가 일치하지 않을 경우
                        //preNode에 tempNode를 할당하고, tempNode에 다음 노드 할당
                        preNode = tempNode;
                        tempNode = tempNode.link;
                    }
                }
            }
        }

        public void deleteNode(){
            ListNode preNode;
            ListNode tempNode;

            //head노드가 null인 경우 모드 노드가 삭제되었으므로 return
            if(head == null){
                return;
            }
            //head 노드의 link가 null인 경우, 즉 노드가 1개남았을경우
            if(head.link == null){
                head = null;
            }else{
                //preNode는 head가 가리키는 노드를 할당
                preNode = head;
                tempNode = head.link;

                //tempNode의 link가 null이 아닐때까지 한 노드씩 다음 노드로 이동
                while(tempNode.link != null){
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }

                //preNode의 link를 null로 만들어 마지막 노드를 삭제
                preNode.link = null;
            }
        }

        public ListNode searchNode(String data){
            ListNode tempNode = head;

            while(tempNode != null){
                if(data.equals(tempNode.getData())){
                    return tempNode;
                }else{
                    tempNode = tempNode.link;
                }
            }
            return tempNode;
        }

        public void printList(){
            ListNode tempNode = head;

            while(tempNode != null){
                System.out.println("tempNode = " + tempNode.getData());
                tempNode = tempNode.link;
            }
        }
    }

}












































