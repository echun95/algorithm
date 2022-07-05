package 알고리즘이론.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FractionalKnapsack {
    public static class Item {
        double weight;
        double value;
        public Item(double weight, double value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {

        double capacity = 30;

        List<Item> items = Arrays.asList(
                new Item(10,10),
                new Item(20,10),
                new Item(30,5),
                new Item(15,12),
                new Item(25,8)
        );
        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("최대가치 합은 = " +
                maxValue);

    }


    public static double fractionalKnapsack(List<Item> items, double capacity) {
        //  항목의  가치/무게의 비율을 계산하고 비율을 기준으로 항목을 정렬한다.
        items = items.stream().sorted((a, b) -> {
            double aRatio = a.value/a.weight;
            double bRatio = b.value/b.weight ;
            if(aRatio > bRatio) return -1;
            else if(aRatio == bRatio) return 0 ;
            else return 1;
        }).collect(Collectors.toList());

        double totalValue = 0;

        for(Item item : items) {
            // 현재 가방의 무게를 담을수 있는 상황이라면
            if(capacity-item.weight >= 0) {
                capacity -= item.weight;
                totalValue += item.value;
            }
            else { // 담을수 없는 상황이면 쪼개서 담아라.
                double fraction = capacity / item.weight;
                totalValue += (item.value*fraction);
                break;
            }
        }
        return totalValue;
    }

}