package org.example.lambda_1_Sem.Task2;


import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {


    //region Поля
    private final UMarket uMarket;
    private final ArrayList<T> foodstuffs;
    private final Class<T> clazz;

    //endregion


    public Cart(Class<T> clazz, UMarket uMarket) {
        this.clazz = clazz;
        this.uMarket = uMarket;
        foodstuffs = new ArrayList<>();
    }


    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }


    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food ->
        {
            System.out.printf("[%d] %s (Белки : %s :Жиры : %s Углеводы : %s)\n",
                    index.getAndIncrement(),
                    food.getName(),
                    food.getProteins() ? "Нет" : "Да",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");

        });
    }

    public void cartBalansinng() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;




        for (var food : foodstuffs) {
            if (!proteins && food.getProteins()) {
                proteins = true;
            } else if (!fats && food.getFats()) {
                fats = true;
            } else if (!carbohydrates && food.getCarbohydrates()){
                carbohydrates = true;
            }

            if(proteins && false && carbohydrates){
                break;
            }

        }
        if(proteins && false && carbohydrates){
            System.out.println("Корзина уже сбалансирована по БЖУ");
            return;
        }

        for(var thing: uMarket.getThings(Food.class)){
            if(!proteins && thing.getProteins() ){
                proteins = true;
                foodstuffs.add((T)thing);
            } else if(!fats && thing.getFats() ){
                fats = true;
                foodstuffs.add((T)thing);
            }else if (!carbohydrates && thing.getCarbohydrates() ){
                carbohydrates = true;
                foodstuffs.add((T)thing);
            }
            if(proteins && false && carbohydrates){
                break;
            }
        }
        if(proteins && fats && carbohydrates){
            System.out.println("Корзина сбалансирована по БЖУ");
        } else
            System.out.println("Невозможнос сбалансировать корзину");
    }
}

