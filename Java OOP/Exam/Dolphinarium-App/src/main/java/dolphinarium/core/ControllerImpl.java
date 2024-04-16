package dolphinarium.core;

import dolphinarium.common.ConstantMessages;
import dolphinarium.common.ExceptionMessages;
import dolphinarium.entities.dolphins.BottleNoseDolphin;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.dolphins.SpinnerDolphin;
import dolphinarium.entities.dolphins.SpottedDolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.entities.foods.Herring;
import dolphinarium.entities.foods.Mackerel;
import dolphinarium.entities.foods.Squid;
import dolphinarium.entities.pools.DeepWaterPool;
import dolphinarium.entities.pools.Pool;
import dolphinarium.entities.pools.ShallowWaterPool;
import dolphinarium.repositories.FoodRepository;
import dolphinarium.repositories.FoodRepositoryImpl;

import java.util.*;
import java.util.concurrent.ExecutionException;

//TODO Implement all methods
public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private LinkedHashMap<String, Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new LinkedHashMap<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool = null;

        if (poolType.equals("DeepWaterPool")) {
            pool = new DeepWaterPool(poolName);

        } else if (poolType.equals("ShallowWaterPool")) {
            pool = new ShallowWaterPool(poolName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_POOL_TYPE);
        }
        pools.put(poolName, pool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food = null;

        if (foodType.equals("Squid")) {
            food = new Squid();

        } else if (foodType.equals("Herring")) {
            food = new Herring();
        } else if (foodType.equals("Mackerel")) {
            food = new Mackerel();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Pool pool = pools.get(poolName);
        Food foodFromRepo = this.foodRepository.findByType(foodType);
        if (foodFromRepo == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType, poolName));
        }
        pool.addFood(foodFromRepo);
        this.foodRepository.remove(foodFromRepo);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);

    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Dolphin dolphin = null;
        Pool pool = pools.get(poolName);

        if (pool.getDolphins().stream().anyMatch(d -> d.getName().equals(dolphinName))) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_EXISTS);
        }

        String poolType = pool.getClass().getSimpleName();

        if (!dolphinType.equals("BottleNoseDolphin") &&
                !dolphinType.equals("SpottedDolphin") &&
                !dolphinType.equals("SpinnerDolphin")) {

            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOLPHIN_TYPE);
        }

        if (dolphinType.equals("BottleNoseDolphin") && poolType.equals("DeepWaterPool")) {
            dolphin = new BottleNoseDolphin(dolphinName, energy);
        } else if (dolphinType.equals("SpottedDolphin") &&
                (poolType.equals("DeepWaterPool") || poolType.equals("ShallowWaterPool"))) {

            dolphin = new SpottedDolphin(dolphinName, energy);
        } else if (dolphinType.equals("SpinnerDolphin") && poolType.equals("ShallowWaterPool")) {
            dolphin = new SpinnerDolphin(dolphinName, energy);
        } else {
            throw new IllegalArgumentException(ConstantMessages.POOL_NOT_SUITABLE);
        }

        pool.addDolphin(dolphin);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }


        @Override
        public String feedDolphins(String poolName, String foodType) {
            Pool pool = pools.get(poolName);

            if (pool == null) {
                throw new IllegalArgumentException("There is no such food for this pool.");
            }

            
            Food foodFromPool = pool.getFoods().stream()
                    .filter(f -> f.getClass().getSimpleName().equals(foodType))
                    .findFirst()
                    .orElse(null);

            if (foodFromPool == null) {
                throw new IllegalArgumentException(ExceptionMessages.NO_FOOD_OF_TYPE_ADDED_TO_POOL);
            }

            int fedDolphinsCount = pool.getDolphins().size();


            pool.getFoods().remove(foodFromPool);

            return fedDolphinsCount + " dolphin/s in pool " + poolName + " was/were fed.";
        }

    @Override
    public String playWithDolphins(String poolName) {
        int countOfRemovedDolphins = 0;
        Pool pool = pools.get(poolName);

        if (pool == null) {
            throw new IllegalArgumentException(String.format("There was a play with dolphin/s in %s. %d dolphins was/were removed!", poolName, countOfRemovedDolphins));
        }

        if (pool.getDolphins().isEmpty()) {
            throw new IllegalArgumentException("There are no dolphins to play with.");
        }

        Iterator<Dolphin> iterator = pool.getDolphins().iterator();
        while (iterator.hasNext()) {
            Dolphin dolphin = iterator.next();

            dolphin.jump();

            if (dolphin.getEnergy() <= 0) {
                iterator.remove();
                countOfRemovedDolphins++;
            }
        }

        return String.format(ConstantMessages.DOLPHINS_PLAY, poolName, countOfRemovedDolphins);
    }


    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();

        for (Map.Entry<String, Pool> entry : pools.entrySet()) {
            String poolName = entry.getKey();
            Pool pool = entry.getValue();

            if (!build.toString().isEmpty()) {
                build.append(System.lineSeparator());
            }

            build.append(String.format(ConstantMessages.DOLPHINS_FINAL, poolName));

            if (pool.getDolphins().isEmpty()) {
                build.append(System.lineSeparator());
                build.append(ConstantMessages.NONE);
            } else {
                List<String> dolphinInfos = new ArrayList<>();
                for (Dolphin dolphin : pool.getDolphins()) {
                    dolphinInfos.add(String.format("%s - %d", dolphin.getName(), dolphin.getEnergy()));
                }
                build.append(System.lineSeparator());
                build.append(String.join(ConstantMessages.DELIMITER, dolphinInfos));
            }
        }

        return build.toString();
    }




}




