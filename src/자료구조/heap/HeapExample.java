package 자료구조.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapExample {




}
//부모 노드 인덱스 번호 = 자식 노드 인덱스 번호 / 2
//왼쪽 자식 노드 인덱스 번호 = 부모 노드 인덱스 번호 * 2
//오른쪽 자식 노드 인덱스 번호 = 부모 노드 인덱스 번호 * 2 + 1

class Heap {
    List<Integer> heap = new ArrayList<>();

    public Heap() {
        this.heap.add(null);
    }

    public boolean insert(int value){
        heap.add(value);
        return true;
    }
}













































