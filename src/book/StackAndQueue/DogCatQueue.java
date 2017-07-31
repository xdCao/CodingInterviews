package book.StackAndQueue;

import java.util.Queue;

/**
 * Created by xdcao on 2017/7/28.
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private Long count;

    public DogCatQueue(Queue<PetEnterQueue> dogQ, Queue<PetEnterQueue> catQ) {
        this.dogQ = dogQ;
        this.catQ = catQ;
        this.count=0l;
    }

    public void add(Pet pet){
        if (pet.getPetType().equals("Dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if (pet.getPetType().equals("Cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new RuntimeException("err,not dog or cat");
        }
    }

    public Pet pollAll(){
        if (!dogQ.isEmpty()&&!catQ.isEmpty()){
            if (dogQ.peek().getCount()<catQ.peek().getCount()){
                return dogQ.poll().getPet();
            }else {
                return catQ.poll().getPet();
            }
        }else if (!dogQ.isEmpty()){
            return dogQ.poll().getPet();
        }else if (!catQ.isEmpty()){
            return catQ.poll().getPet();
        }else {
            throw new RuntimeException("err,queue is empty");
        }
    }



    public Dog pollDog(){
        if (dogQ.isEmpty()){
            throw new RuntimeException("no dog");
        }else {
            return (Dog) dogQ.poll().getPet();
        }
    }

    public Cat pollCat(){
        if (catQ.isEmpty()){
            throw new RuntimeException("err,no cat");
        }else {
            return (Cat)catQ.poll().getPet();
        }
    }


    public boolean isEmpty(){
        if (dogQ.isEmpty()&&catQ.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean isDogEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQ.isEmpty();
    }


}
