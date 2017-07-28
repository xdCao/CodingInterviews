package StackAndQueue;

/**
 * Created by xdcao on 2017/7/28.
 */
public class PetEnterQueue {

    private Pet pet;
    private Long count;

    public PetEnterQueue(Pet pet, Long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public Long getCount() {
        return count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }

}
